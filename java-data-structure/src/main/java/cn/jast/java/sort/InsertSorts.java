package cn.jast.java.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 1. 直接插入排序
 * 2. shell排序
 *
 * TODO
 */
public class InsertSorts {

    public static void main(String[] args) {
        int[] arr = {2, 4, 8, 3, 9, 5, 7,1};
        System.out.println(Arrays.toString(new MergeSort().mergeSort(arr)));
    }

    static class MergeSort{

        public int[] mergeSort(int[] arr){
            if(arr==null||arr.length==0){
                return new int[0];
            }
            doMergeSort(arr,0,arr.length-1);
            return  arr;
        }


        /**
         * 归并排序
         *
         * @param arr
         * @param low
         * @param high
         */
        private void doMergeSort(int[] arr, int low, int high) {
            //递归出口：只有一个元素时，就是有序的
            if (low == high) {
                return;
            }
            // 将数组一分为二，分治
            int mid = (low + high) / 2;
            // 左数组归并排序
            doMergeSort(arr, low, mid);
            // 右数组归并排序
            doMergeSort(arr, mid + 1, high);
            // 合并有序的左右数组
            merge(arr, low, mid + 1 , high);
        }

        /**
         * 合并有序的左右数组
         * lowIndex 到 midIndex-1 是有序的，midIndex 到 highIndex 是有序的
         * 将数组拆分成左右两个数组，右数组包含mid，将左、右数组合并到数组low到high的位置上
         * @param arr
         * @param lowIndex
         * @param midIndex
         * @param highIndex
         */
        private void merge(int[] arr, int lowIndex, int midIndex, int highIndex) {
            int leftSize = midIndex-lowIndex;
            int rightSize = highIndex-midIndex+1;
            //取出左、右数组
            int[] left = new int[leftSize];
            int[] right = new int[rightSize];

            //将arr中下标为 lowIndex 到 minIdex-1 的元素复制到左数组中
            int k = lowIndex;
            int i;
            for(i = 0;i < leftSize ; i++){
                left[i] = arr[k++];
            }

            //将arr中下标为 midIndex 到 highIndex 的元素复制到右数组中
            k= midIndex;
            for(i = 0;i < rightSize ;i++){
                right[i] = arr[k++];
            }

//            System.out.println(Arrays.toString(left));
//            System.out.println(Arrays.toString(right));

            //合并左右数组中较小的元素到 arr 中下标从 lowIndex 到 highIndex 的位置上
            i = 0;
            int j = 0;
            int index = lowIndex; //！！注意
            while(i < leftSize && j < rightSize){
                if(left[i] > right[j]){ //取大值时是降序，取小值时是升序
                    arr[index++] = left[i++];
                }else{
                    arr[index++] = right[j++];
                }
            }
            while(i<leftSize){
                arr[index++] = left[i++];
            }
            while(j<rightSize){
                arr[index++] = right[j++];
            }
        }

    }

}
