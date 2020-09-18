package cn.jast.java.data.structure.stack;

public class ArrayStack<T> implements Stack<T>{

    private Object[] data;
    /**
     * 指向栈顶的位置
     */
    private int top;
    /**
     * 可存放的元素个数
     */
    private int availableSize;

    public ArrayStack(int size) {
        this.data = new Object[size];
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean push(T t) {
        return false;
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T top() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
