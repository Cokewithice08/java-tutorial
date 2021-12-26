package io.github.jast90.jdbc;

import io.github.jast90.jdbc.client.operation.TableOperation;
import org.junit.Test;

public class TableOperationTest {

    String db = "jdbc";

    @Test
    public void createTable(){
        String sql = "create table test(id int not null primary key auto_increment comment '测试',title varchar(128) comment '标题')";
        TableOperation tableOperation = new TableOperation();
        tableOperation.create(db,sql);
    }

    @Test
    public void alterComment(){
        TableOperation tableOperation = new TableOperation();
        tableOperation.alterComment(db,"test","测试表");
    }

    @Test
    public void alterEngine(){
        TableOperation tableOperation = new TableOperation();
        tableOperation.alterEngine(db,"test","MyISAM");
    }
    @Test
    public void alterCharacterSet(){
        TableOperation tableOperation = new TableOperation();
        tableOperation.alterCharacterSet(db,"test","GBK");
    }


    @Test
    public void showCreateTable(){
        TableOperation tableOperation = new TableOperation();
        System.out.println(tableOperation.showCreateTable(db, "myTest"));
    }


    @Test
    public void alterName(){
        TableOperation tableOperation = new TableOperation();
//        tableOperation.alterName(db,"test","myTest");
        tableOperation.alterName(db,"myTest","test");
    }


    @Test
    public void showColumns(){
        TableOperation tableOperation = new TableOperation();
        System.out.println(tableOperation.showColumns(db, "test"));
    }

    @Test
    public void dropTable(){
        TableOperation tableOperation = new TableOperation();
        tableOperation.dropTable(db,"test");
    }
}
