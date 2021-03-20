package io.github.jast90.aqs.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by jast90 on 2021/3/20
 */
public class CyclicBarrierTest {

    /**
     * CyclicBarrier(int parties, Runnable barrierAction)  用于在线程达到屏障时，优先执行barrierAction
     */
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
/**
 * 输出结果:
 * 1
 * 2
 * 或者
 * 2
 * 1
 *
 */