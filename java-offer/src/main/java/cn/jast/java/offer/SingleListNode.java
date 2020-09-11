package cn.jast.java.offer;

public class SingleListNode {
    private int key;
    private SingleListNode next;

    public SingleListNode() {
    }

    public SingleListNode(int key, SingleListNode next) {
        this.key = key;
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public SingleListNode getNext() {
        return next;
    }

    public void setNext(SingleListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SingleListNode{" +
                "key=" + key +
                ", next=" + next +
                '}';
    }
}
