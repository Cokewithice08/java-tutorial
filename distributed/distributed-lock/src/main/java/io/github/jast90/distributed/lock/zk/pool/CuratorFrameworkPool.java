package io.github.jast90.distributed.lock.zk.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.curator.framework.CuratorFramework;

public class CuratorFrameworkPool {

    protected GenericObjectPool<CuratorFramework> internalPool;

    public CuratorFrameworkPool(PooledObjectFactory<CuratorFramework> factory) {
        this.internalPool = new GenericObjectPool<>(factory,new GenericObjectPoolConfig());
    }

    public CuratorFramework getResource() throws Exception {
        return internalPool.borrowObject();
    }

    public void returnResource(CuratorFramework curatorFramework){
        internalPool.returnObject(curatorFramework);
    }
}
