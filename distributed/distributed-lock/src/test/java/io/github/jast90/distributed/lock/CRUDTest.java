package io.github.jast90.distributed.lock;

import org.apache.zookeeper.CreateMode;
import org.junit.Test;

import java.util.List;

public class CRUDTest extends BaseTest{

    @Test
    public void create() throws Exception {
        String path = "/lock/100";
        for(int i = 0;i<20;i++){
            String ourPath = client.create().creatingParentContainersIfNeeded().withProtection().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(path+"/lock");
            System.out.println(ourPath);
        }
        List<String> children = client.getChildren().forPath(path);
        System.out.println(children);
    }
}
