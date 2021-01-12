package cn.jast.jvm.argumemt;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {


    public HeapOOM() {
    }

    /**
     * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/zhangzhiwen/jvm-files/heap-dump.hprof
     * -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:/Users/zhangzhiwen/jvm-files/mygc.log
     * @param args
     */
    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();
        while (true){
            list.add(new HeapOOM());
        }
    }
}
