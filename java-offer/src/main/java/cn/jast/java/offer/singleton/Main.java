package cn.jast.java.offer.singleton;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        testSimpleLazySingleton();
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
            if(executorService.isShutdown())
                if(singletonSet.size()>1){
                    System.out.println("简单单例存在创建多个实例对象，实例如下：");
                    System.out.println(singletonSet);
                }
            break;
        }
    }
}
