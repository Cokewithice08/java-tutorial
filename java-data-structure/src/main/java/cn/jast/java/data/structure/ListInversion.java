package cn.jast.java.data.structure;

import java.util.Stack;

public class ListInversion {


    public void print(SingleListNode singleListNode){
        Stack<SingleListNode> stack = new Stack<>();
        SingleListNode next = singleListNode;
        while (next!=null){
            stack.push(next);
            next = next.getNext();
        }
        while (stack.size()>0){
            System.out.println(stack.pop().getKey());
        }
    }

    public static void main(String[] args) {
        ListInversion listInversion = new ListInversion();
        SingleListNode root = null;
        for (int i = 0; i < 10; i++) {
            root = new SingleListNode(i,root);
        }
        System.out.println(root);
        listInversion.print(root);
    }
}
