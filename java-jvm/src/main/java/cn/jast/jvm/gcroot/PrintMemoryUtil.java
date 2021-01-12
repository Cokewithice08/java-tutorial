package cn.jast.jvm.gcroot;

/**
 * Created by jast90 on 2021/1/9
 */
public class PrintMemoryUtil {

    public static void printMemory(){
        System.out.println("free is :"+Runtime.getRuntime().freeMemory()/1024/1024 + "M");
        System.out.println("total is :"+Runtime.getRuntime().totalMemory()/1024/1024 + "M");
    }
}
