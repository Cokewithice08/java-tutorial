package io.github.jast90.java.api;

import java.util.HashMap;

/**
 * Created by jast90 on 2021/5/1
 */
public class HashMapAnalyzer {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        System.out.println(Integer.valueOf(1).hashCode());
        hashMap.put(Integer.valueOf(1),Integer.valueOf(1));
    }
}
