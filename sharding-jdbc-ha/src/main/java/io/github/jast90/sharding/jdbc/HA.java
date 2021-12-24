package io.github.jast90.sharding.jdbc;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithmConfiguration;
import org.apache.shardingsphere.infra.config.mode.ModeConfiguration;
import org.apache.shardingsphere.mode.repository.cluster.ClusterPersistRepositoryConfiguration;
import org.apache.shardingsphere.mode.repository.cluster.zookeeper.props.ZookeeperPropertyKey;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/16 10:36
 */
public class HA {

    public static void main(String[] args) throws SQLException {

        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        // 配置第 1 个数据源
        HikariDataSource dataSource1 = new HikariDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setJdbcUrl("jdbc:mysql://192.168.56.102:3306/ds0");
        dataSource1.setUsername("root");
        dataSource1.setPassword("123456");
        dataSourceMap.put("ds0", dataSource1);

        // 配置第 2 个数据源
        HikariDataSource dataSource2 = new HikariDataSource();
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setJdbcUrl("jdbc:mysql://192.168.56.102:3306/ds1");
        dataSource2.setUsername("root");
        dataSource2.setPassword("123456");
        dataSourceMap.put("ds1", dataSource2);
        // 配置 t_order 表规则
        ShardingTableRuleConfiguration orderTableRuleConfig = new ShardingTableRuleConfiguration("t_order",
                "ds${0..1}.t_order${0..1}");
        // 配置分库策略
        orderTableRuleConfig.setDatabaseShardingStrategy(
                new StandardShardingStrategyConfiguration("user_id",
                        "dbShardingAlgorithm"));
        // 配置分表策略
        orderTableRuleConfig.setTableShardingStrategy(new StandardShardingStrategyConfiguration("order_id", "tableShardingAlgorithm"));
        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTables().add(orderTableRuleConfig);

        // 配置分库算法
        Properties dbShardingAlgorithmrProps = new Properties();
        dbShardingAlgorithmrProps.setProperty("algorithm-expression", "ds${user_id % 2}");
        shardingRuleConfig.getShardingAlgorithms().put("dbShardingAlgorithm", new ShardingSphereAlgorithmConfiguration("INLINE", dbShardingAlgorithmrProps));

        // 配置分表算法
        Properties tableShardingAlgorithmrProps = new Properties();
        tableShardingAlgorithmrProps.setProperty("algorithm-expression", "t_order${order_id % 2}");
        shardingRuleConfig.getShardingAlgorithms().put("tableShardingAlgorithm", new ShardingSphereAlgorithmConfiguration("INLINE", tableShardingAlgorithmrProps));

        Properties properties = new Properties();
        properties.setProperty(ZookeeperPropertyKey.OPERATION_TIMEOUT_MILLISECONDS.getKey(),String.valueOf(10000));
        properties.setProperty(ZookeeperPropertyKey.RETRY_INTERVAL_MILLISECONDS.getKey(),String.valueOf(10000));

        ClusterPersistRepositoryConfiguration registryCenterConfig = new ClusterPersistRepositoryConfiguration(
                "Zookeeper",
                "governance-sharding-data-source",
                "192.168.56.102:2181",
                properties);
        // 配置 Cluster Config
        ModeConfiguration modeConfig = new ModeConfiguration("Cluster", registryCenterConfig, true);

        // 创建 ShardingSphereDataSource
        DataSource dataSource = ShardingSphereDataSourceFactory.createDataSource(modeConfig,dataSourceMap, Collections.singletonList(shardingRuleConfig),
                new Properties());

        String sql = "SELECT o.* FROM t_order o WHERE o.user_id=? AND o.order_id=?";

        try (Connection conn = dataSource.getConnection();) {
            batchInsert(conn);
        }

    }

    private static void batchInsert(Connection connection){
        String insertSQL = "insert into t_order(order_id,user_id) values(?,?)";
        try (PreparedStatement ps = connection.prepareStatement(insertSQL)) {
            for (int i = 0; i < 100; i++) {
                ps.setLong(1, i);
                ps.setLong(2, new Random().nextInt(10));
                ps.addBatch();
                ps.clearParameters();
            }
            System.out.println(Arrays.toString(ps.executeBatch()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void query(Connection connection){
        String sql = "SELECT o.* FROM t_order o WHERE o.user_id=? AND o.order_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
