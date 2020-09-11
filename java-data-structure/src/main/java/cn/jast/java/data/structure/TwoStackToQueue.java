package cn.jast.java.data.structure;

import java.util.Stack;

/**
 * 题目描述
 * 用两个栈来实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入节点和在队列头部删除节点的功能
 *
 * 测试用例
 * 往空队列里添加、删除元素
 * 往非空队列里添加、删除元素
 * 连续删除元素直至队列为空
 *
 * @param <T>
 */
public class TwoStackToQueue<T> {
    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public void appendTail(T e){
        stack1.push(e);
    }

    public T deleteHead(){
        if(stack2.size()==0){
            if(stack1.size()>0){
                while (stack1.size()>0){
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }

    public int size(){
        return stack1.size()+stack2.size();
    }


    public static void main(String[] args) {
        TwoStackToQueue<Integer> twoStackToQueue = new TwoStackToQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            twoStackToQueue.appendTail(i);
        }

        System.out.println(twoStackToQueue.deleteHead());

        System.out.println("");

        twoStackToQueue.appendTail(10);

        System.out.println(twoStackToQueue.deleteHead()+"\r\n");

        while (twoStackToQueue.size()>0){
            System.out.println(twoStackToQueue.deleteHead());
        }

        twoStackToQueue.appendTail(11);

        System.out.println("\r\n"+twoStackToQueue.deleteHead());
    }

}
