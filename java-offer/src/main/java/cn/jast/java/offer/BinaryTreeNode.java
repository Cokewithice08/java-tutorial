package cn.jast.java.offer;

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
    public static void preOrderTraverseByRecursion(BinaryTreeNode root){
        if(root != null){
            System.out.println(root.key);
            preOrderTraverseByRecursion(root.getLeft());
            preOrderTraverseByRecursion(root.getRight());
        }
    }

    /**
     * 先序遍历（非递归）
     * @param root
     */
    public static void preOrderTraverseByNonRecursion(BinaryTreeNode root){

    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10,
                new BinaryTreeNode(20,new BinaryTreeNode(19,new BinaryTreeNode(12),new BinaryTreeNode(17)),null),
                new BinaryTreeNode(9));
        BinaryTreeNode.preOrderTraverseByRecursion(root);
    }

}
