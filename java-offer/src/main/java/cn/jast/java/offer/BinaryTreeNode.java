package cn.jast.java.offer;

import java.util.ArrayList;
import java.util.List;

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
     * @param root
     */
    public static List<Integer> preOrderTraverseByRecursion(BinaryTreeNode root,List<Integer> list){
        if(root != null){
            list.add(root.getKey());
            preOrderTraverseByRecursion(root.getLeft(),list);
            preOrderTraverseByRecursion(root.getRight(),list);
        }
        return list;
    }

    /**
     * 先序遍历（非递归）
     * @param root
     */
    public static void preOrderTraverseByNonRecursion(BinaryTreeNode root){

    }

    /**
     * 中序遍历
     * @param root
     */
    public static List<Integer> inOrderTraverseByRecursion(BinaryTreeNode root,List<Integer> list){
        if(list == null){
            list = new ArrayList<>();
        }
        if(root!=null){
            inOrderTraverseByRecursion(root.getLeft(),list);
            list.add(root.getKey());
            inOrderTraverseByRecursion(root.getRight(),list);
        }
        return list;
    }

    /**
     * 中序遍历（非递归）
     * @param root
     */
    public static List<Integer> inOrderTraverseByNonRecursion(BinaryTreeNode root,List<Integer> list){
        return list;
    }

    /**
     * 后序遍历
     * @param root
     */
    public static List<Integer> postOrderTraverseByRecursion(BinaryTreeNode root,List<Integer> list){
        if(list == null){
            list = new ArrayList<>();
        }
        if(root!=null){
            postOrderTraverseByRecursion(root.getLeft(),list);
            postOrderTraverseByRecursion(root.getRight(),list);
            list.add(root.getKey());
        }
        return list;
    }

    /**
     * 后续遍历（非递归）
     * @param root
     */
    public static void postOrderTraverseByNonRecursion(BinaryTreeNode root){

    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10,
                new BinaryTreeNode(20,new BinaryTreeNode(19,new BinaryTreeNode(12),new BinaryTreeNode(17)),null),
                new BinaryTreeNode(9));
        BinaryTreeNode.preOrderTraverseByRecursion(root,new ArrayList<>()).forEach(System.out::println);
//        inOrderTraverseByRecursion(root,new ArrayList<>()).forEach(System.out::println);
//        postOrderTraverseByRecursion(root,new ArrayList<>()).forEach(System.out::println);
    }

}
