package cn.jast.java.data.structure.list;

/**
 * 单链表
 * TODO
 */
public class SinglyLinkedList<T> implements List<T> {

    private Node head;

    private Node tail;

    private int size;

    public SinglyLinkedList() {
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int length() {
        return size;
    }


    @Override
    public boolean delete(int p) {
        if(p > length()){
            return false;
        }
        if(isEmpty()){
            return false;
        }

        if(p == 1){
            head = head.next;
            return true;
        }

        int i = 1;
        Node<T> current = head;
        Node<T> parent = head;
        while(i < p && current != null){
            i++;
            parent = current;
            current = current.next;
        }
        parent.next = current.next;
        return true;
    }

    @Override
    public int getPos(T t) {
        Node current = head;
        int i = 1;
        while(current != null && current.value != t){
            current = current.next;
            i++;
        }
        if(current == null){
            return -1;
        }
        return i;
    }

    @Override
    public boolean append(T t) {
        Node node = new Node(t);
        if (head == null) {
            head = node;
        }
        if (tail == null) {
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean appendHead(T t) {
        Node node = new Node(t);
        if(head == null){
            head = node;
        }else{
            Node temp = head;
            head = node;
            node.next = temp;
        }
        if(tail == null){
            tail = node;
        }
        size++;
        return false;
    }

    @Override
    public boolean insert(int p, T t) {
        Node<T> node = new Node<>(t);
        if(p == 1){
            node.next = head;
            head = node;
            return true;
        }

        Node<T> current = head;
        Node<T> parent = head;
        int count = 1;
        while(count < p && current != null){
            count++;
            parent = current;
            current = current.next;
        }

        node.next = parent.next;
        parent.next = node;
        if(p > length()){
            tail = node;
        }
        return true;
    }

    @Override
    public T getValue(int p) {
        Node<T> current = head;
        int i = 1;
        while(current!=null && i++ < p){
            current = current.next;
        }
        if(current == null){
            return null;
        }
        return current.value;
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    class Node<T> {
        private T value;
        private Node next;

        Node(T value) {
            this.value = value;
        }

        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList s1 = new SinglyLinkedList<Integer>();
        s1.append(1);
        s1.append(2);
        s1.append(3);
        s1.append(4);
        System.out.println(s1);
        System.out.println(s1.getValue(2));
        System.out.println(s1.getPos(2));
        System.out.println(s1.isEmpty());
        System.out.println(s1.delete(5));
        System.out.println(s1);
        s1.insert(5,5);
        System.out.println(s1);
    }
}
