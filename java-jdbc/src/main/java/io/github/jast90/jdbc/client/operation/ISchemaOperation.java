package io.github.jast90.jdbc.client.operation;

import java.util.List;

/**
 * 数据库操作
 *
 *  @author zhangzhiwen
 *  @date 2021/12/10 11:34
 */
public interface ISchemaOperation {

    void create(String db);

    List<String> tables(String db);

    List<String> databases();
}
