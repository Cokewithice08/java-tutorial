package cn.jast.threadPool.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPools {

    public static void fixed() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do work");
        });
        executorService.shutdown();
        while (true) {
            if (executorService.isShutdown()) {
                break;
            }
        }
    }

    public static void scheduled() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.schedule(() -> {
            System.out.println("10秒后运行的任务");
        }, 10, TimeUnit.SECONDS);

        pool.shutdown();
        int i = 0;
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i++);
        }
    }

    public static void scheduledAtFixedRate() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(() -> {
            System.out.println("1秒后 每隔1秒 运行的任务");
        }, 1,1, TimeUnit.SECONDS);
    }

    public static void scheduleWithFixedDelay() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleWithFixedDelay(() -> {
            System.out.println("1秒后 每隔1秒 运行的任务");
        }, 1,1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
//        fixed();
//        scheduled();
//        scheduledAtFixedRate();
        scheduleWithFixedDelay();
    }

}
