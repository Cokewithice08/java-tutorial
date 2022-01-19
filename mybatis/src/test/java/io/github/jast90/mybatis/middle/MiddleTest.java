package io.github.jast90.mybatis.middle;

import io.github.jast90.mybatis.BaseTest;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2022/1/19 13:39
 */
public class MiddleTest extends BaseTest {

    private static RedissonClient redisson;

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.56.102:6379");
        redisson = Redisson.create(config);
    }

    private void doReadAndWrite(String key1, String key2) {
        RReadWriteLock readWriteLock = redisson.getReadWriteLock(String.format("%s-%s", key1, key2));
        SqlSession session = getSession();
        MiddleMapper mapper = session.getMapper(MiddleMapper.class);
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();
        try {
            if (readLock.tryLock()) {
                if (query(key1, key2, mapper)) {
                    return;
                }
            }
        } finally {
            readLock.unlock();
        }

        try {
            if (writeLock.tryLock()) {
                save(key1, key2, mapper);
            }
        } finally {
            writeLock.unlock();
            session.commit();
        }
    }

    private boolean query(String key1, String key2, MiddleMapper mapper) {
        int query = mapper.query(key1, key2);
        if (query > 0) {
            return true;
        }
        return false;
    }

    private void save(String key1, String key2, MiddleMapper mapper) {
        Middle middle = new Middle();
        middle.setKey1(key1);
        middle.setKey2(key2);
        mapper.save(middle);
        System.out.println("保存数据成功");
    }

    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 50; i++) {
            executorService.execute(() -> {
                doReadAndWrite("s1", "s2");
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println("done");
                redisson.shutdown();
                break;
            }
        }
    }
}
