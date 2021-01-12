package cn.jast.jvm.gcroot;

/**
 * Stack Local - local variable or parameter of Java method
 *
 * Created by jast90 on 2021/1/9
 */
public class GCRootStackLocal {

    private int _10MB = 10 * 1024 * 1024;
    private byte[] memory = new byte[8 * _10MB];

    public static void main(String[] args) {
        System.out.println("start:");
        PrintMemoryUtil.printMemory();
        test();
        System.gc();// 注：gc会回收方法栈test中的local
        System.out.println("第二次GC完成");
        PrintMemoryUtil.printMemory();
    }

    public static void test(){
        GCRootStackLocal local = new GCRootStackLocal();//栈变量
        PrintMemoryUtil.printMemory();
        System.gc(); // 注：gc不会回收local
        System.out.println("第一次GC完成");
        PrintMemoryUtil.printMemory();
    }

}

/**
 * 输出：
 * start:
 * free is :120M
 * total is :123M
 * free is :40M
 * total is :123M
 * 第一次GC完成
 * free is :41M
 * total is :123M
 * 第二次GC完成
 * free is :121M
 * total is :123M
 */
