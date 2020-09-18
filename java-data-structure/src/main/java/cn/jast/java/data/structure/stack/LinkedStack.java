package cn.jast.java.data.structure.stack;

public class LinkedStack<T> implements Stack<T>{

    private class Node{
        private T t;
        private Node next;
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
