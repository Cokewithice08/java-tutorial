package cn.jast.java.data.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lists {

    public static void main(String[] args) {
//        remove();
        List<List<Integer>> re= new ArrayList<>();
        re.add(Arrays.asList(1,2,3));
        re.clear();
        System.out.println(re.toArray());
    }

    public static void remove(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.remove(i));
        }


    }
}
