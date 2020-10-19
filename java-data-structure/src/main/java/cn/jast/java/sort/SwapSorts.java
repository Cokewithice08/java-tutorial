package cn.jast.java.sort;

import java.util.Arrays;

/**
 * 交换排序
 * 1. 冒泡排序：稳定；时间O(n^2)；空间O(1)
 * 2. 快速排序
 */
public class SwapSorts extends AbstractSorts {

    public static void main(String[] args) {
        int[] arr = {2, 4, 8, 3, 9, 5, 7,1};
        System.out.println(Arrays.toString(new SwapSorts().quickSort(arr)));
    }

    public int[] quickSort(int[] arr) {
        return new QuickSort().quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快排：重点是交换，一定会改变数组
     *
     */
    static class QuickSort extends AbstractSorts {

        /**
         * 快排
         * @param arr
         * @param start
         * @param end
         * @return
         */
        int[] quickSort(int[] arr, int start, int end) {
            if (start >= end) {
                return new int[0];
            }

            int pivot = partition(arr, start, end);

            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);

            return arr;
        }

        /**
         * 选择轴值的策略
         * @param start
         * @param end
         * @return
         */
        int selectPivot(int start, int end) {
            //尽量均匀
            return (start + end) / 2;
        }

        /**
         * 确定轴值并将其划分为轴值以前全部小于轴值，轴值以后全部大于轴值
         *
         * @param arr
         * @param start
         * @param end
         * @return
         */
        int partition(int[] arr, int start, int end) {
            int pivot = selectPivot(start, end);
            swap(arr, pivot, end);

            int temp = arr[end];
            int s = start;
            int e = end;
            while (s != e) {
                //从前往后找，找到比轴值大的，并将大的和终止位置交换
                while (arr[s] <= temp && e > s) {
                    s++;
                }
                if (s < e) {
                    arr[e] = arr[s];
                    e--;
                }

                //从后往前找，找到比轴值小的，并将小的和起始位置交换
                while (arr[e] >= temp && e > s) {
                    e--;
                }
                if (s < e) {
                    arr[s] = arr[e];
                    s++;
                }
            }
            arr[s] = temp;
            return s;
        }
    }
}
