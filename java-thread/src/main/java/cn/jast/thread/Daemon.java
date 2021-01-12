package cn.jast.thread;

import java.util.concurrent.TimeUnit;

public class Daemon {
    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //不会输出到控制台
                System.out.println("DaemonThread finally run.");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }
}
