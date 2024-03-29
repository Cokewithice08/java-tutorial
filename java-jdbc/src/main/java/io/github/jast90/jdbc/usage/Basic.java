package io.github.jast90.jdbc.usage;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangzhiwen
 * @Description: JDBC 基本使用
 * @date 2021/12/9 10:49
 */
public class Basic {
    final static String url = "jdbc:mysql://192.168.56.102:3306";
    final static String username = "root";
    final static String password = "123456";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
//        createTable();
//        dropTable();
//        insert();
//        query();
//        showCreateTable();
//        alterTable();
        batchInsert();

    }

    public static boolean createTable() {
        String sql = "create table post(id int not null primary key auto_increment,title varchar(128)) engine InnoDB character set utf8";
        return doExecute(sql, "createTable");
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            connection.setCatalog("jdbc");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    private static boolean doExecute(String sql, String action) {
        boolean result = false;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            result = true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        }
        if (result) {
            System.out.println(String.format("%s table success", action));
        }
        return result;
    }

    public static boolean alterTable() {
        String sql = "alter table post add (`desc` varchar(128) not null)";
        return doExecute(sql, "alterTable");
    }

    public static void showCreateTable() {
        try {
            String sql = "show create table post";
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
        } catch (Exception e) {

        }
    }

    public static boolean dropTable() throws SQLException {
        String sql = "drop table post";
        return doExecute(sql, "dropTable");
    }

    public static boolean insert() throws SQLException {
        String sql = "insert into post(title,`desc`) values(?,?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "Mybatis.");
        preparedStatement.setString(2, "Mybatis.");
        if (preparedStatement.executeUpdate() == 1) {
            System.out.println("插入数据成功");
            return true;
        }
        return false;
    }

    public static boolean batchInsert() throws SQLException {
        List<Post> posts = Lists.newArrayList();
        for (int i=0;i<=3;i++){
            Post post = new Post();
            post.setTitle("hello"+i);
            post.setDecs("hello"+i);
            posts.add(post);
        }
        String sql = "insert into post(title,`desc`) values(?,?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (Post each : posts) {
            preparedStatement.setString(1, each.getTitle());
            preparedStatement.setString(2, each.getDecs());
            preparedStatement.addBatch();
            preparedStatement.clearParameters();
        }
        int[] count = preparedStatement.executeBatch();
        if (count.length>0) {
            System.out.println(Arrays.toString(count));
            System.out.println("插入数据成功");
            return true;
        }
        return false;
    }

    public static void query() {
        String sql = "select id,title from post";
        List<Post> posts = doQuery(sql, Post.class);
        System.out.println(posts);
    }

    private static <T> List<T> doQuery(String sql, Class<T> tClass, Object... param) {
        List<T> list = new ArrayList<>(0);
        //获取查询sql字段
        List<String> columns = ReflectUtil.columns(sql);
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //填充参数
            ReflectUtil.fillParams(preparedStatement, param);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                T t = tClass.newInstance();
                for (String column : columns) {
                    //字段赋值
                    ReflectUtil.setFieldValue(t, resultSet, column, columns.indexOf(column) + 1, tClass);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
