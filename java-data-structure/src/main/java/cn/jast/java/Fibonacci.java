package cn.jast.java;

/**
 * Created by jast90 on 2021/4/2
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fb(4));
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
    //
    //TODO
    public static long fb1(int n) {
        int[] data = {0,1};
        if(n < 2){
            return data[n];
        }
        int fb_n_1 = 1;//保存 n-1的斐波那契的值
        int fb_n_2 = 0;//保存n-2的斐波那契的值
        int result = 0;
        for(int i = 2 ; i <= n ; i ++){
            result = fb_n_1 + fb_n_2;
            fb_n_2 = fb_n_1;
            fb_n_1 = result;
        }
        return result;
    }
}
