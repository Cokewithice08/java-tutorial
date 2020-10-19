package cn.jast.java.sort;

/**
 * 抽象排序
 */
public abstract class AbstractSorts {
    /**
     * 交换数组中下标为i,j元素
     * @param arr
     * @param i
     * @param j
     */
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
