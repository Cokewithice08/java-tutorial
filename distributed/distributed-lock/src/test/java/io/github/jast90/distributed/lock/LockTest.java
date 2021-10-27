package io.github.jast90.distributed.lock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LockTest {

    LockService lockService = new LockService();

    @Test
    public void lock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            if(i%3 == 0){
                executorService.submit(()->{
                    lockService.reduceStock(100);
                });
            }else if(i%3 == 1){
                executorService.submit(()->{
                    lockService.reduceStock(101);
                });
            }else{
                executorService.submit(()->{
                    lockService.reduceStock(102);
                });
            }
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
    }
}
