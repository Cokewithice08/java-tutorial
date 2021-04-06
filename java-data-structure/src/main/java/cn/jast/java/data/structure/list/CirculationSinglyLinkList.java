package cn.jast.java.data.structure.list;

/**
 * 循环单链表
 * TODO
 */
public class CirculationSinglyLinkList<T> implements List<T>{

    private Node<T> head;

    private int size;

    public CirculationSinglyLinkList() {
        this.head = new Node<>(null);
        head.next = this.head;
    }

    @Override
    public boolean isEmpty() {
        return head.next ==head;
    }

    @Override
    public void clear() {
        head.next = head;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean append(T t) {
        Node<T> node = new Node<>(t,head.next);
        head.next = node;
        size++;
        return true;
    }

    @Override
    public boolean appendHead(T t) {
        return false;
    }

    @Override
    public boolean insert(int p, T t) {
        return false;
    }

    @Override
    public boolean delete(int p) {
        return false;
    }

    @Override
    public T getValue(int p) {
        return null;
    }

    @Override
    public int getFirstPos(T t) {
        return 0;
    }

    @Override
    public String toString() {
        return "CirculationSinglyLinkList{" +
                "head=" + head.value +
                '}';
    }

    private static class Node<T>{
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }

        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CirculationSinglyLinkList<Integer> circulationSinglyLinkList = new CirculationSinglyLinkList<>();
        System.out.println(circulationSinglyLinkList.isEmpty());
        circulationSinglyLinkList.append(0);
        circulationSinglyLinkList.append(1);
        circulationSinglyLinkList.append(2);
        System.out.println(circulationSinglyLinkList.length());
    }
}
