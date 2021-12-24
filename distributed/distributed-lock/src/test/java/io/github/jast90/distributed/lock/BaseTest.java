package io.github.jast90.distributed.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    protected CuratorFramework client;

    @Before
    public void before(){
        this.client = CuratorFrameworkFactory.newClient("192.168.56.102:2181",
                new ExponentialBackoffRetry(1000, 3));
        client.start();
    }

    @After
    public void after(){
        client.close();
    }
}
