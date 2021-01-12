package cn.jast.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
    static Object lock = new Object();
    static Boolean flag = true;

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    System.out.println(String.format("%s flag is true. wait @ %s", Thread.currentThread()
                            , new SimpleDateFormat("HH:mm:ss").format(new Date())));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {

                    }
                }
                System.out.println(String.format("%s flag is false. running @ %s", Thread.currentThread()
                        , new SimpleDateFormat("HH:mm:ss").format(new Date())));
            }
        }
    }
    static class Notify implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                System.out.println(String.format("%s hold lock. notify @ %s", Thread.currentThread()
                        , new SimpleDateFormat("HH:mm:ss").format(new Date())));
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                }
            }
            synchronized (lock){
                System.out.println(String.format("%s hold lock again. running @ %s", Thread.currentThread()
                        , new SimpleDateFormat("HH:mm:ss").format(new Date())));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(),"waitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(),"notifyThread");
        notifyThread.start();
    }
}
