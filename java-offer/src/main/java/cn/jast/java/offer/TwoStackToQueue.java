package cn.jast.java.offer;

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
        System.out.println("入队："+e);
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
        T t =stack2.pop();
        System.out.println("出队："+t);
        return t;
    }

    public int size(){
        return stack1.size()+stack2.size();
    }


    public static void main(String[] args) {
        TwoStackToQueue<Integer> twoStackToQueue = new TwoStackToQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            twoStackToQueue.appendTail(i);
        }

        twoStackToQueue.appendTail(10);

        while (twoStackToQueue.size()>0){
           twoStackToQueue.deleteHead();
        }

        twoStackToQueue.appendTail(11);

        twoStackToQueue.deleteHead();
    }

}
