package io.github.jast90.distributed.lock.zk;

import io.github.jast90.distributed.lock.IDistributedLock;
import io.github.jast90.distributed.lock.zk.pool.CuratorFactory;
import io.github.jast90.distributed.lock.zk.pool.CuratorFrameworkPool;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

public class ZKDistributedLock implements IDistributedLock {

    private InterProcessMutex lock;

    private CuratorFrameworkPool pool;

    private CuratorFramework resource;
    private boolean usePool;

    public ZKDistributedLock(String lockName){
        this(lockName,true);
    }

    public ZKDistributedLock(String lockName,boolean usePool){
        this.usePool = usePool;
        try {
            if(usePool){
                pool = new CuratorFrameworkPool(new CuratorFactory("192.168.56.101:2181"));
                resource = pool.getResource();
            }else{
                resource = CuratorFrameworkFactory.newClient("192.168.56.101:2181", new ExponentialBackoffRetry(1000, 3));
                resource.start();
            }

            lock = new InterProcessMutex(resource,lockName);
        }catch (Exception e){

        }
    }

    @Override
    public boolean tryLock() throws Exception {
        return this.tryLock(10,TimeUnit.SECONDS);
    }

    @Override
    public boolean tryLock(long time, TimeUnit timeUnit) throws Exception {
        return lock.acquire(time,timeUnit);
    }

    @Override
    public void unlock() throws Exception {
        lock.release();
        if( this.usePool ){
            pool.returnResource(resource);
        }
    }
}
