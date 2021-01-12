package cn.jast.thread;

import java.util.concurrent.TimeUnit;

public class Interrupted {
    /**
     * 会响应中断
     */
    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {

            }
        }
    }

    /**
     * 不会响应中断
     */
    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is "+sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is "+busyThread.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
    }

}
