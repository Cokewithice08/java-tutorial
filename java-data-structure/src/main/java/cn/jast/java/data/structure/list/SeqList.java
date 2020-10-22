package cn.jast.java.data.structure.list;

import java.util.Arrays;

/**
 * 顺序表
 * <p>
 */
public class SeqList<T> implements List<T> {

    private Object[] data;

    private int size;

    private int maxSize;

    public SeqList(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Object[this.maxSize];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        this.data = new Object[this.maxSize];
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean append(T t) {
        this.data[size++] = t;
        return true;
    }

    @Override
    public boolean appendHead(T t) {
        if (size == maxSize) {
            return false;
        }
        size = size + 1;
        int index = size;
        while (index > 0) {
            data[index] = data[index - 1];
            index--;
        }
        data[0] = t;
        return true;
    }

    @Override
    public boolean insert(int p, T t) {
        if (size == maxSize) {
            return false;
        }

        for (int i = size + 1 - 1; i >= p - 1; i--) {
            data[i] = data[i - 1];
        }
        data[p - 1] = t;
        return true;
    }

    @Override
    public boolean delete(int p) {
        for(int i = p-1;i<size;i++){
            data[i] = data[i+1];
        }
        size = size-1;
        return true;
    }

    @Override
    public T getValue(int p) {
        if(length()<p){
            return null;
        }
        return (T) data[p-1];
    }

    @Override
    public int getFirstPos(T t) {
        int index = -1;

        for(int i = 0 ; i<length() ; i++){
            if(data[i]==t){
                index = i;
                break;
            }
        }
        if(index == -1){
            return index;
        }
        return index + 1;
    }

    @Override
    public String toString() {
        return "SeqList{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public static void main(String[] args) {
        SeqList<Integer> seqList = new SeqList<>(10);
        seqList.append(1);
        seqList.appendHead(2);
        seqList.appendHead(3);
        System.out.println(seqList);
        System.out.println(seqList.length());
        seqList.append(4);
        System.out.println(seqList);
        System.out.println(seqList.length());
        seqList.delete(2);
        System.out.println(seqList);
        System.out.println(seqList.length());
        System.out.println(seqList.getValue(2));
        System.out.println(seqList.getFirstPos(3));
    }
}
