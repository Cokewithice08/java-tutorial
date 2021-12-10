package io.github.jast90.jdbc.client.operation;

import io.github.jast90.jdbc.client.util.ConfigUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/10 13:57
 */
public class SchemaOperation extends AbstractOperation implements ISchemaOperation{
    private final String schemaProperties = "schema.properties";
    @Override
    public void create(String db) {
        String createSchemaSQl = String.format(ConfigUtil.get(schemaProperties, "createSchema", String.class),db);
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createSchemaSQl);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {

        }
    }

    @Override
    public List<String> tables(String db) {
        String showTablesSQl = ConfigUtil.get(schemaProperties, "showTables", String.class);
        List<String> tables = new ArrayList<>();
        Connection connection = getConnection(db);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(showTablesSQl);
            while (resultSet.next()){
                tables.add(resultSet.getString(1));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {

        }
        return tables;
    }

    @Override
    public List<String> databases() {
        String showTablesSQl = ConfigUtil.get(schemaProperties, "showDatabases", String.class);
        List<String> databases = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(showTablesSQl);
            while (resultSet.next()){
                databases.add(resultSet.getString(1));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {

        }
        return databases;
    }
}
