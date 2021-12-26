package io.github.jast90.jdbc.client.operation;

import io.github.jast90.jdbc.client.util.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/10 13:47
 */
public class AbstractOperation {

    private DbConfig config;

    public AbstractOperation() {
        this.config = new DbConfig();
    }

    protected Connection getConnection(String db){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(config.getUrl(),
                    config.getUsername(),
                    config.getPassword());
            connection.setCatalog(db);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    protected Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(config.getUrl(),
                    config.getUsername(),
                    config.getPassword());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    protected boolean doExecute(String sql,String db,String action){
        boolean result = false;
        Connection connection = getConnection(db);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            result = true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        }
        if(result){
            System.out.println(String.format("%s success",action));
        }
        return result;
    }

    protected ResultSet doExecute(String sql, String db){
        Connection connection = getConnection(db);
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {

        }
        return resultSet;
    }
}
