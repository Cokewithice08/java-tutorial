package cn.jast.java.data.structure.stack;

/**
 * 单链表实现的栈
 * 入栈时，旧栈顶节点作为新节点的下一节点，新节点为新的栈顶节点
 * 出站时，旧栈顶节点作为新栈顶节点。
 * @param <T>
 */
public class LinkedStack<T> implements Stack<T> {

    /**
     * 栈顶引用
     */
    private Node<T> top;
    /**
     * 栈大小
     */
    private int size;

    private class Node<T> {
        private T t;
        private Node next;

        public Node() {
        }

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean push(T t) {
        Node node = new Node(t, top);
        top = node;
        size++;
        return true;
    }

    @Override
    public T pop() {
        if (size == 0) {
            return null;
        }
        Node<T> topNode = top;
        top = topNode.getNext();
        size--;
        return topNode.getT();
    }

    @Override
    public T top() {
        Node<T> topNode = top;
        if (top == null) {
            return null;
        }
        return topNode.getT();
    }

    @Override
    public boolean isEmpty() {
        throw new RuntimeException();
    }

    @Override
    public boolean isFull() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        for (int i = 0; i < 10; i++) {
            linkedStack.push(i);
        }
        while (linkedStack.size()>0){
            System.out.println(linkedStack.pop());
        }
    }
}
