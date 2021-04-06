package cn.jast.java;

/**
 * Created by jast90 on 2021/4/2
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fb1(4));
    }

    //递归实现
    public static long fb(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fb(n - 1) + fb(n - 2);
    }

    //非递归实现
    //TODO
    public static long fb1(int n) {
        int i = 0;
        int result = 0;
        while (i < n) {
            result += i++;
        }
        return result;
    }
}
