package cn.jast.java.sort;

import java.util.Arrays;

/**
 * 交换排序
 * 1. 冒泡排序：稳定；时间O(n^2)；空间O(1)
 * 2. 快速排序
 * 3. 堆排序
 */
public class SwapSorts extends AbstractSorts {

    public static void main(String[] args) {
        int[] arr = {2, 4, 8, 3, 9, 5, 7,1};
//        System.out.println(Arrays.toString(new SwapSorts().quickSort(arr)));
        System.out.println(Arrays.toString(new HeapSort().heapSort(arr)));
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

    /**
     * 堆排序：通过堆实现排序
     */
    static class HeapSort extends AbstractSorts{
        //将某个节点堆化：将其自己堆化，并且将交换位置的子节点也进行堆化确保交换后还是一个堆
        // a：数组； n: 数组长度；i：数组中第i个元素，待堆化的元素
        private void heapify(int a[] , int n , int i){
            //递归出口
            if(i >= n){
                return ;
            }
            int c1 = 2 * i + 1;//左子节点，确保存在（不超过数组长度）
            int c2 = 2 * i + 2;//右子节点，确保存在（不超过数组长度）
            int max = i;
            if(c1 < n && a[c1] > a[max]){
                max = c1;
            }
            if(c2 < n && a[c2] > a[max]){
                max = c2;
            }
            if(max != i){
                swap(a,i,max);
                heapify(a,n,max);
            }
        }

        // 将数组构建成堆
        // a :待构建的数组，n：数组的长度
        private void buildHeap(int a[] , int n){
            int last_node = n-1;
            int last_node_parent = (last_node-1)/2;
            for(int i = last_node_parent ; i >= 0 ; i--){
                heapify(a,n,i);
            }
        }

        // 堆排序
        public int[] heapSort(int a[]){
            if(a == null|| a.length==0){
                return new int[0];
            }
            int n = a.length;
            //数组堆化
            buildHeap(a,n);
            //交换最后一个元素
            for(int i = n-1 ; i>=0 ; i--){
                //交换第0和最后一个元素
                swap(a,0,i);
                //对堆顶元素堆化
                heapify(a,i,0);
            }
            return a;
        }

    }
}
