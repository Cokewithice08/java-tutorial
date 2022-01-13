package io.github.jast90.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        testSimpleLazySingleton();
//        testSynchronized1Singleton();
//        testSynchronized2Singleton();
//        testStaticInitializeSingleton();
//        testNestedClassSingleton();
    }

    private static ExecutorService getThreadPool() {
        int size = 50;
        AtomicInteger failCount = new AtomicInteger(0);
        ExecutorService executorService = new ThreadPoolExecutor(size, size, 0L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setUncaughtExceptionHandler((t, e) -> {
                    failCount.incrementAndGet();
                    e.printStackTrace();
                    System.out.println("failCount" + failCount.get());
                });
                return thread;
            }
        });
        return executorService;
    }


    /**
     * 测试简单单例的线程安全
     */
    public static void testSimpleLazySingleton() {
        Set<SimpleLazySingleton> singletonSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService executorService = getThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                SimpleLazySingleton simpleLazySingleton = SimpleLazySingleton.getInstance();
                singletonSet.add(simpleLazySingleton);
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                if (singletonSet.size() > 1) {
                    System.out.println("简单单例存在创建多个实例对象，实例如下：");
                    System.out.println(singletonSet);
                }
                break;
            }

        }
    }

    /**
     * 测试线程安全的单例模式实现
     */
    public static void testSynchronized1Singleton() {
        long startTime = System.currentTimeMillis();
        Set<Synchronized1Singleton> singletonSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService executorService = getThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                Synchronized1Singleton singleton = Synchronized1Singleton.getInstance();
                singletonSet.add(singleton);
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println(String.format("执行时间：%s ms", System.currentTimeMillis() - startTime));
                if (singletonSet.size() > 1) {
                    System.out.println("简单单例存在创建多个实例对象，实例如下：");
                    System.out.println(singletonSet);
                }
                break;
            }

        }
    }

    /**
     * Synchronized2Singleton 的效率比 Synchronized1Singleton高几倍甚至几十倍以上
     */
    public static void testSynchronized2Singleton() {
        long startTime = System.currentTimeMillis();
        Set<Synchronized2Singleton> singletonSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService executorService = getThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                Synchronized2Singleton singleton = Synchronized2Singleton.getInstance();
                singletonSet.add(singleton);
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println(String.format("执行时间：%s ms", System.currentTimeMillis() - startTime));
                if (singletonSet.size() > 1) {
                    System.out.println("简单单例存在创建多个实例对象，实例如下：");
                    System.out.println(singletonSet);
                }
                break;
            }

        }
    }

    /**
     *
     */
    public static void testStaticInitializeSingleton() {
        Set<Synchronized2Singleton> singletonSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService executorService = getThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                Synchronized2Singleton singleton = Synchronized2Singleton.getInstance();
                singletonSet.add(singleton);
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                if (singletonSet.size() > 1) {
                    System.out.println("简单单例存在创建多个实例对象，实例如下：");
                    System.out.println(singletonSet);
                }
                break;
            }

        }
    }

    public static void testNestedClassSingleton() {
        Set<StaticInnerClassSingleton> singletonSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService executorService = getThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getInstance();
                singletonSet.add(singleton);
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                if (singletonSet.size() > 1) {
                    System.out.println("简单单例存在创建多个实例对象，实例如下：");
                    System.out.println(singletonSet);
                }
                break;
            }

        }
    }
}
