package io.github.jast90.distributed.lock.zk.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorFactory extends BasePooledObjectFactory<CuratorFramework> {

    private String connectString;

    public CuratorFactory(String connectString) {
        this.connectString = connectString;
    }

    @Override
    public CuratorFramework create() throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(connectString, new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();
        return curatorFramework;
    }

    @Override
    public PooledObject<CuratorFramework> wrap(CuratorFramework curatorFramework) {
        return new DefaultPooledObject<>(curatorFramework);
    }
}
