package cn.jast.java.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeNode {
    private int key;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int key) {
        this.key = key;
    }

    public BinaryTreeNode(int key, BinaryTreeNode left, BinaryTreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }


    /**
     * 先序遍历（递归）
     *
     * @param root
     */
    public static List<Integer> preOrderTraverseByRecursion(BinaryTreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.getKey());
            preOrderTraverseByRecursion(root.getLeft(), list);
            preOrderTraverseByRecursion(root.getRight(), list);
        }
        return list;
    }

    /**
     * 先序遍历（非递归）
     * 通过栈来避免递归（有节点入栈）
     *
     * @param root
     */
    public static List<Integer> preOrderTraverseByNonRecursion(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();// 用于存放遍历后的结果
        Stack<BinaryTreeNode> stack = new Stack();// 用于存放右子树节点
        BinaryTreeNode p = root;
        //左子树和右子树都未遍历时，遍历
        while (p != null || stack.size() > 0) {
            if (p != null) { //左子树不为空时，遍历左子树
                list.add(p.getKey());//当前节点输出
                stack.push(p.getRight());//右子树入栈，待左子树遍历完后遍历右子树
                p = p.getLeft();//遍历左子树
            } else { //左子树遍历完后，遍历右子树
                p = stack.pop();
            }
        }
        return list;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static List<Integer> inOrderTraverseByRecursion(BinaryTreeNode root, List<Integer> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (root != null) {
            inOrderTraverseByRecursion(root.getLeft(), list);
            list.add(root.getKey());
            inOrderTraverseByRecursion(root.getRight(), list);
        }
        return list;
    }

    /**
     * 中序遍历（非递归）
     *
     * @param root
     */
    public static List<Integer> inOrderTraverseByNonRecursion(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;
        //遍历节点的左子树并将根结点入栈，直到左子树为null时，然后出栈获取节点并遍历该节点的右子树的左子树直到为null
        while(current != null || !stack.empty()){
            if(current != null){
                stack.push(current);
                current = current.getLeft();
            }else{
               BinaryTreeNode top = stack.pop();
               list.add(top.getKey());
               current = top.getRight();
            }
        }
        return list;
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public static List<Integer> postOrderTraverseByRecursion(BinaryTreeNode root, List<Integer> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (root != null) {
            postOrderTraverseByRecursion(root.getLeft(), list);
            postOrderTraverseByRecursion(root.getRight(), list);
            list.add(root.getKey());
        }
        return list;
    }

    /**
     * 后续遍历（非递归）
     *
     * @param root
     */
    public static void postOrderTraverseByNonRecursion(BinaryTreeNode root) {

    }

    /**
     * 层序遍历
     *
     * @param root
     * @param list
     * @return
     */
    public static List<Integer> layerOrderTraverse(BinaryTreeNode root, List<Integer> list) {

        return list;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10,
                new BinaryTreeNode(20, new BinaryTreeNode(19, new BinaryTreeNode(12), new BinaryTreeNode(17)), null),
                new BinaryTreeNode(9,new BinaryTreeNode(6,null,new BinaryTreeNode(7)),new BinaryTreeNode(8)));
//        BinaryTreeNode.preOrderTraverseByRecursion(root, new ArrayList<>()).forEach(System.out::println);
//        inOrderTraverseByRecursion(root,new ArrayList<>()).forEach(System.out::println);
//        postOrderTraverseByRecursion(root,new ArrayList<>()).forEach(System.out::println);
//        preOrderTraverseByNonRecursion(root);
        inOrderTraverseByNonRecursion(root).forEach(System.out::println);
    }

}
