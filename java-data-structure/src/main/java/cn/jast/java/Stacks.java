package cn.jast.java;

import java.util.Iterator;
import java.util.Stack;

public class Stacks {

    public static void iterator(){
        int i=10;
        Stack<Integer> stack = new Stack<Integer>();
        for (int j = 0; j < i; j++) {
            stack.push(j);
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

//        Iterator<Integer> it = stack.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
    }

    public static void minNumberInRotateArray(int [] array) {
        if(array==null||array.length==0){
//            return 0;
        }
        int low = 0,high = array.length-1;
        while(low + high == array.length){

            if((low+1) < array.length && array[low] < array[low+1]){
                low++;
            }
            if(high-1>=0 && array[high]>array[high-1]){
                high--;
            }
        }

        System.out.println(low);
        System.out.println(high);
    }

    public static void main(String[] args) {
        int[] a = {3,4,5,1,2};
        minNumberInRotateArray(a);
    }
}
