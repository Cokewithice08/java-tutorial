package cn.jast.java.offer.singleton;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
//        testSimpleLazySingleton();
        testSynchronizedSingleton1();
        testSynchronizedSingleton2();
    }


    /**
     * 测试简单单例的线程安全
     */
    public static void testSimpleLazySingleton(){
        Set<SimpleLazySingleton> singletonSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                SimpleLazySingleton simpleLazySingleton = SimpleLazySingleton.getInstance();
                singletonSet.add(simpleLazySingleton);
            });
        }
        executorService.shutdown();
        while(true){
            if(executorService.isShutdown()){
                if(singletonSet.size()>1){
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
    public static void testSynchronizedSingleton1(){
        long startTime = System.currentTimeMillis();
        Set<SynchronizedSingleton1> singletonSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                SynchronizedSingleton1 singleton = SynchronizedSingleton1.getInstance();
                singletonSet.add(singleton);
            });
        }
        executorService.shutdown();
        while(true){
            if(executorService.isShutdown()){
                System.out.println(String.format("执行时间：%s ms",System.currentTimeMillis()-startTime));
                if(singletonSet.size()>1){
                    System.out.println("简单单例存在创建多个实例对象，实例如下：");
                    System.out.println(singletonSet);
                }
                break;
            }

        }
    }

    /**
     * SynchronizedSingleton2 的效率比 testSynchronizedSingleton1高几倍甚至几十倍以上
     */
    public static void testSynchronizedSingleton2(){
        long startTime = System.currentTimeMillis();
        Set<SynchronizedSingleton2> singletonSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                SynchronizedSingleton2 singleton = SynchronizedSingleton2.getInstance();
                singletonSet.add(singleton);
            });
        }
        executorService.shutdown();
        while(true){
            if(executorService.isShutdown()){
                System.out.println(String.format("执行时间：%s ms",System.currentTimeMillis()-startTime));
                if(singletonSet.size()>1){
                    System.out.println("简单单例存在创建多个实例对象，实例如下：");
                    System.out.println(singletonSet);
                }
                break;
            }

        }
    }
}
