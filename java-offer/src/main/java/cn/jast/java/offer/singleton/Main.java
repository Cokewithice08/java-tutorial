package cn.jast.java.offer.singleton;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
//        testSimpleLazySingleton();
//        testSynchronized1Singleton();
//        testSynchronized2Singleton();
//        testStaticInitializeSingleton();
        testNestedClassSingleton();
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
    public static void testSynchronized1Singleton(){
        long startTime = System.currentTimeMillis();
        Set<Synchronized1Singleton> singletonSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                Synchronized1Singleton singleton = Synchronized1Singleton.getInstance();
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
     * Synchronized2Singleton 的效率比 Synchronized1Singleton高几倍甚至几十倍以上
     */
    public static void testSynchronized2Singleton(){
        long startTime = System.currentTimeMillis();
        Set<Synchronized2Singleton> singletonSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                Synchronized2Singleton singleton = Synchronized2Singleton.getInstance();
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
     *
     */
    public static void testStaticInitializeSingleton(){
        Set<Synchronized2Singleton> singletonSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                Synchronized2Singleton singleton = Synchronized2Singleton.getInstance();
                singletonSet.add(singleton);
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

    public static void testNestedClassSingleton(){
        Set<StaticInnerClassSingleton> singletonSet = Collections.synchronizedSet(new HashSet<>());
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getInstance();
                singletonSet.add(singleton);
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
}
