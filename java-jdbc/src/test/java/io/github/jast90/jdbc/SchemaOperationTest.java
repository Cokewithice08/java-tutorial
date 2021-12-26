package io.github.jast90.jdbc;

import io.github.jast90.jdbc.client.operation.SchemaOperation;
import org.junit.Test;

import java.util.List;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/10 14:44
 */
public class SchemaOperationTest {

    @Test
    public void tables(){
        List<String> tables = new SchemaOperation().tables("jdbc");
        System.out.println(tables);
    }

    @Test
    public void create(){
        new SchemaOperation().create("jdbc");
    }

    @Test
    public void databases(){
        List<String> databases = new SchemaOperation().databases();
        System.out.println(databases);
    }


}
