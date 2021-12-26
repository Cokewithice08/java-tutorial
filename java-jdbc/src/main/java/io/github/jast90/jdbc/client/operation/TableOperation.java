package io.github.jast90.jdbc.client.operation;


import io.github.jast90.jdbc.client.domain.Column;
import io.github.jast90.jdbc.client.util.ConfigUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TableOperation extends AbstractOperation implements ITableOperation{
    final static String tableProperties = "table.properties";
    @Override
    public void create(String db, String sql) {
        doExecute(sql,db,"createTable");
    }

    @Override
    public void alterName(String db, String oldName, String newName) {
        String sql = String.format(ConfigUtil.get(tableProperties,"alterName",String.class),oldName,newName);
        doExecute(sql,db,"alterName");
    }

    @Override
    public void alterCharacterSet(String db, String table, String characterSet) {
        String sql = String.format(ConfigUtil.get(tableProperties,"alterCharacterSet",String.class),table,characterSet);
        doExecute(sql,db,"alterCharacterSet");
    }

    @Override
    public void alterEngine(String db, String table, String engine) {
        String sql = String.format(ConfigUtil.get(tableProperties,"alterEngine",String.class),table,engine);
        doExecute(sql,db,"alterEngine");
    }

    @Override
    public void alterComment(String db, String table, String comment) {
        String sql = String.format(ConfigUtil.get(tableProperties,"alterComment",String.class),table,comment);
        doExecute(sql,db,"alterComment");
    }

    @Override
    public void dropTable(String db, String table) {
        String sql = String.format(ConfigUtil.get(tableProperties,"dropTable",String.class),table);
        doExecute(sql,db,"dropTable");
    }

    @Override
    public String showCreateTable(String db, String table) {
        String createTableSQL = null;
        String sql = String.format(ConfigUtil.get(tableProperties,"showCreateTable",String.class),table);
        Connection connection = getConnection(db);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                createTableSQL = resultSet.getString(2);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return createTableSQL;
    }

    @Override
    public List<Column> showColumns(String db, String table) {
        List<Column> columns = new ArrayList<>(0);
        String sql = String.format(ConfigUtil.get(tableProperties,"showColumns",String.class),table);
        Connection connection = getConnection(db);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Column column;
            while (resultSet.next()){
                column = new Column();
                column.setField(resultSet.getString(1));
                column.setType(resultSet.getString(2));
                column.setNull(resultSet.getString(3));
                column.setKey(resultSet.getString(4));
                column.setDefault(resultSet.getString(5));
                column.setExtra(resultSet.getString(6));
                columns.add(column);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return columns;
    }
}
