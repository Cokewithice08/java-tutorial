package cn.jast.java;

import java.util.*;

public class Integers {


    public static void main(String[] args) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int[] data = new int[0];
        for(int i : data){
            hash.put(i,hash.containsKey(i)?(hash.get(i)+1):1);
        }
        System.out.println(hash);
        List<Integer> re = new ArrayList<>();
        re.add(1);
        re.add(2);
        re.add(3);

    }
}
