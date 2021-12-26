package io.github.jast90.jdbc.client.operation;

import io.github.jast90.jdbc.client.domain.Column;

import java.util.List;

/**
 * 表操作
 *
 * @author zhangzhiwen
 * @date 2021/12/10 13:30
 */
public interface ITableOperation {

    void create(String db,String sql);

    void alterName(String db,String oldName,String newName);

    void alterCharacterSet(String db,String table,String characterSet);

    void alterEngine(String db,String table,String engine);

    void alterComment(String db,String table,String comment);

    void dropTable(String db,String table);

    String showCreateTable(String db,String table);

    List<Column> showColumns(String db,String table);
}
