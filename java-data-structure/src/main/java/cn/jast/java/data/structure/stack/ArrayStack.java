package cn.jast.java.data.structure.stack;

public class ArrayStack<T> implements Stack<T> {

    private Object[] data;
    /**
     * 指向栈顶的位置
     */
    private int top;
    /**
     * 可存放的元素个数
     */
    private int maxSize;

    public ArrayStack(int size) {
        this.data = new Object[size];
        this.maxSize = size;
        this.top = -1;
    }

    @Override
    public void clear() {
        top = -1;
    }

    @Override
    public boolean push(T t) {
        if (top == maxSize - 1) {
            return false;
        }
        data[++top] = t;
        return false;
    }

    @Override
    public T pop() {
        if (top == -1) {
            return null;
        }
        return (T) data[top--];
    }

    @Override
    public T top() {
        if (top == -1) {
            return null;
        }
        return (T) data[top];
    }

    @Override
    public boolean isEmpty(){
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        while (!stack.isEmpty()){
            System.out.println("栈是否为满："+stack.isFull());
            System.out.println(stack.pop());
            System.out.println("栈是否为空："+stack.isEmpty());
        }
    }
}
