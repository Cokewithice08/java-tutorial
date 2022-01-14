package io.github.jast90.jta.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "io.github.jast90.jta")
public class SpringConfig {

    @Bean("firstDatasource")
    public DataSource firstDatasource(){
        AtomikosDataSourceBean dataSource1Bean = new AtomikosDataSourceBean();
        dataSource1Bean.setUniqueResourceName("ds1");
        dataSource1Bean.setBorrowConnectionTimeout(60);
        dataSource1Bean.setReapTimeout(20);

        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setUrl("jdbc:mysql://localhost:3307/jta_user");
        druidXADataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidXADataSource.setUsername("root");
        druidXADataSource.setPassword("123456");

        dataSource1Bean.setXaDataSource(druidXADataSource);
        return dataSource1Bean;
    }

    @Bean("secondDatasource")
    public DataSource secondDatasource(){
        AtomikosDataSourceBean dataSource1Bean = new AtomikosDataSourceBean();
        dataSource1Bean.setUniqueResourceName("ds2");
        dataSource1Bean.setBorrowConnectionTimeout(60);
        dataSource1Bean.setReapTimeout(20);

        DruidXADataSource druidXADataSource = new DruidXADataSource();
        druidXADataSource.setUrl("jdbc:mysql://localhost:3308/jta_order");
        druidXADataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidXADataSource.setUsername("root");
        druidXADataSource.setPassword("123456");

        dataSource1Bean.setXaDataSource(druidXADataSource);
        return dataSource1Bean;
    }


    @Bean("firstJdbcTemplate")
    public JdbcTemplate firstJdbcTemplate(@Qualifier("firstDatasource") DataSource firstDataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(firstDataSource);
        return jdbcTemplate;
    }

    @Bean("secondJdbcTemplate")
    public JdbcTemplate secondJdbcTemplate(@Qualifier("secondDatasource")DataSource secondDataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(secondDataSource);
        return jdbcTemplate;
    }


    /**
     * @MethodName transactionManager
     * @Description 事务管理器，包装了atomikos事务
     */
    @Bean
    public JtaTransactionManager transactionManager() throws Exception {
        JtaTransactionManager transactionManager = new JtaTransactionManager();
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(true);
        userTransactionManager.setTransactionTimeout(3000);
        transactionManager.setUserTransaction(userTransactionManager);
        transactionManager.setAllowCustomIsolationLevels(true);
        return transactionManager;
    }

    /**
     * @MethodName transactionTemplate
     * @Description spring 事务模板，包装了atomikos事务, 主要用于编程式事务
     */
    @Bean
    public TransactionTemplate transactionTemplate() throws Exception {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        JtaTransactionManager transactionManager = new JtaTransactionManager();
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(true);
        userTransactionManager.setTransactionTimeout(3000);
        transactionManager.setUserTransaction(userTransactionManager);
        transactionManager.setAllowCustomIsolationLevels(true);
        transactionTemplate.setTransactionManager(transactionManager);

        return transactionTemplate;
    }
}
