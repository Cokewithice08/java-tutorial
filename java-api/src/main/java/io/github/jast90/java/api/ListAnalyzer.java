package io.github.jast90.java.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jast90 on 2021/4/23
 */
public class ListAnalyzer {

    public static void main(String[] args) {
//        add();
//        fori();
//        foreach();
//        iterator();
        arrayListConcurrenceAdd();
    }

    /**
     * ArrayList 和 LinkedList 插入性能对比
     *
     * 输出：
     * ArrayList add cost time :3849 ms
     * LinkedList add cost time :1296 ms
     *
     */
    public static void add(){
        //ArrayList插入性能分析
        List<Integer> arrayList = new ArrayList<>();
        final int count = 90000000;
        Long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            arrayList.add(i);
        }
        System.out.println(String.format("ArrayList add cost time :%s ms",System.currentTimeMillis()-start));

        List<Integer> linkedList = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            linkedList.add(i);
        }
        System.out.println(String.format("LinkedList add cost time :%s ms",System.currentTimeMillis()-start));
    }

    /**
     * ArrayList 和 LinkedList 遍历 fori 性能对比
     *
     * 输出：
     * ArrayList fori cost time :4 ms
     * LinkedList fori cost time :47 ms
     *
     */
    public static void fori(){

        final int count = 10000;

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            arrayList.add(i);
        }
        List<Integer> linkedList = new LinkedList<>(arrayList);

        Long start = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        for (Integer integer : arrayList) {
        }
        System.out.println(String.format("ArrayList fori cost time :%s ms",System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        System.out.println(String.format("LinkedList fori cost time :%s ms",System.currentTimeMillis()-start));

    }

    /**
     * ArrayList 和 LinkedList 遍历 for : 性能对比
     * 输出：
     * ArrayList foreach cost time :2 ms
     * LinkedList foreach cost time :1 ms
     */
    public static void foreach(){

        final int count = 10000;

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            arrayList.add(i);
        }
        List<Integer> linkedList = new LinkedList<>(arrayList);

        Long start = System.currentTimeMillis();
        int a;
        for (Integer integer : arrayList) {
            a = integer;
        }
        System.out.println(String.format("ArrayList foreach cost time :%s ms",System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        for (Integer integer : linkedList) {
            a = integer;
        }
        System.out.println(String.format("LinkedList foreach cost time :%s ms",System.currentTimeMillis()-start));

    }

    /**
     * ArrayList 和 LinkedList 遍历 iterator 性能对比
     * 输出：
     * ArrayList iterator cost time :1 ms
     * LinkedList iterator cost time :1 ms
     */
    public static void iterator(){

        final int count = 10000;

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            arrayList.add(i);
        }
        List<Integer> linkedList = new LinkedList<>(arrayList);

        Long start = System.currentTimeMillis();
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        System.out.println(String.format("ArrayList iterator cost time :%s ms",System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        iterator = linkedList.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }

        System.out.println(String.format("LinkedList iterator cost time :%s ms",System.currentTimeMillis()-start));

    }

    /**
     * ArrayList 线程安全测试
     */
    public static void arrayListConcurrenceAdd(){
        List<Integer> list = new CopyOnWriteArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for(int i = 0;i<10000;i++){
            pool.submit(()->{
                list.add(1);
            });
        }

        pool.shutdown();
        while (true){
            if(pool.isTerminated()){
                System.out.println(list.size());
                break;
            }
        }

    }
}
