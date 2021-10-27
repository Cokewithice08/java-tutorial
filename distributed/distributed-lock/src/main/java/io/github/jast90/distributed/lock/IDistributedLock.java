package io.github.jast90.distributed.lock;

import java.util.concurrent.TimeUnit;

public interface IDistributedLock {

    boolean tryLock() throws Exception;

    boolean tryLock(long time, TimeUnit timeUnit) throws Exception;

    void unlock() throws Exception;
}
