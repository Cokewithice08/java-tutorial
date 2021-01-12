package cn.jast.jvm.gcroot;

/**
 * Monitor Used - objects used as a monitor for synchronization
 *
 * Created by jast90 on 2021/1/9
 */
public class GCRootMonitorUsed {

    public static void main(String[] args) {
        System.out.println("init");
        PrintMemoryUtil.printMemory();

        BigClass lock = new BigClass();
        System.out.println("create big class");
        PrintMemoryUtil.printMemory();

        System.gc();
        System.out.println("first gc");
        PrintMemoryUtil.printMemory();

        synchronized (lock){
            System.gc();
            System.out.println("second gc");
            PrintMemoryUtil.printMemory();
        }
        lock = null;
        BigClass b1 = new BigClass();
        BigClass b2 = new BigClass();
        System.out.println("third gc");
        PrintMemoryUtil.printMemory();
    }
}
