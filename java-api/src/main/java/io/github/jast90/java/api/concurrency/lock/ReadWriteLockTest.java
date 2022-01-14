package io.github.jast90.java.api.concurrency.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2022/1/17 11:36
 */
public class ReadWriteLockTest {

    public static volatile boolean exist = false;
    public static AtomicInteger count = new AtomicInteger(0);

    public static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();//能锁住

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 50; i++) {
            executorService.execute(() -> {
                test();
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println(count);
                break;
            }
        }
    }

    public static void test() {
//        ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); 锁不住的
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();
        readLock.lock();
        try {
            if (exist) {
                count.incrementAndGet();
                System.out.println("read 数据存在");
                return;
            }
        } catch (Exception e) {

        } finally {
            readLock.unlock();
        }
        writeLock.lock();
        try {
            if (!exist) {
                count.incrementAndGet();
                exist = true;
                System.out.println("更新值");
            } else {
                count.incrementAndGet();
                System.out.println("write 数据存在");
            }
        } finally {
            writeLock.unlock();
        }
    }

    public static void test1() {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {
            if (!exist) {
                exist = true;
            } else {
                System.out.println("数据存在");
                return;
            }
            count.incrementAndGet();
        } finally {
            reentrantLock.unlock();
        }
    }
}
