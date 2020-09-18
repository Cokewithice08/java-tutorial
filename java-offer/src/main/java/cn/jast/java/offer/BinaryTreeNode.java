package cn.jast.java.offer;

import java.util.*;

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
    public static List<Integer> preOrderTraverseWithoutRecursion(BinaryTreeNode root) {
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
    public static List<Integer> inOrderTraverseWithoutRecursion(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;
        //遍历节点的左子树并将根结点入栈，直到左子树为null时，然后出栈获取节点并遍历该节点的右子树的左子树直到为null
        while (current != null || !stack.empty()) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
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
    public static List<Integer> postOrderTraverseWithoutRecursion(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        BinaryTreeNode current;
        while (stack.isEmpty() == false) {
            current = stack.pop();
            if (current != null) {
                list.add(current.getKey());
                stack.push(current.getLeft());
                stack.push(current.getRight());
            }
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 层序遍历（宽度优先遍历）
     * 特点是先进先出，符合队列的特性
     *
     * @param root
     * @return
     */
    public static List<Integer> layerOrderTraverse(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode current;
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            list.add(current.getKey());
            if (current.getLeft() != null) {
                queue.addLast(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.addLast(current.getRight());
            }
        }
        return list;
    }

    /**
     * 根据先序序列和中序序列构造二叉树（递归实现）
     * <p>
     * 先序序列第一个元素是树的根结点，从中序序列中找出与根结点所在位置k:
     * 1.确定根结点的左子树和右子树的中序序列：该位置之前的元素就是根结点左子树的中序序列，该位置之后的元素就是根结点的右子树的中序序列
     * 2.确定根结点的左子树和右子树的先序序列：先序序列第一个元素往后k元素就是根结点左子树的先序序列，k+1位置之后就是根结点右子树的先序序列
     * <p>
     * <p>
     * perOrder[i]~perOrder[j] 是子树的先序序列
     * inOrder[s]~inOrder[t] 是子树的中序序列
     *
     * @param perOrder
     * @param inOrder
     * @param i
     * @param j
     * @param s
     * @param t
     * @return
     */
    public static BinaryTreeNode buildTreeByPerOrderAndInOrder(Integer[] perOrder, Integer[] inOrder, int i, int j, int s, int t) {
        if (i > j) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(perOrder[i]);
        int k;
        k = s;
        while (k <= t && inOrder[k] != perOrder[i]) {
            k++;
        }
        if (k > t) {
            return null;
        }
        root.setLeft(buildTreeByPerOrderAndInOrder(perOrder, inOrder, i + 1, j + k - s, s, k - 1));
        root.setRight(buildTreeByPerOrderAndInOrder(perOrder, inOrder, i + k - s + 1, j, k + 1, t));
        return root;
    }

    /**
     * 根据后序序列和中序序列构造二叉树（递归实现）
     *
     * postOrder[i]~postOrder[j]是子树的后序序列
     * inOrder[s]~inOrder[t]是子树的中序序列
     *
     * @param postOrder
     * @param inOrder
     * @param i
     * @param j
     * @param s
     * @param t
     * @return
     */
    public static BinaryTreeNode buildTreeByPostOrderAndInOrder(Integer[] postOrder, Integer[] inOrder, int i, int j, int s, int t) {
        if (i > j) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(postOrder[j]);
        int k;
        k = s;
        while (k <= t && inOrder[k] != postOrder[j]) {
            k++;
        }
        if (k > t) {
            return null;
        }
        //左子树个数
        int countLeft = k - s;
        //右子树个数
        int countRight = t - k;

        if (countLeft == 0) {
            //左子树为null
            root.setRight(buildTreeByPostOrderAndInOrder(postOrder, inOrder, j - countRight, j - 1, t - countRight + 1, t));
        } else if (countRight == 0) {
            //右子树为null
            root.setLeft(buildTreeByPostOrderAndInOrder(postOrder, inOrder, j - countLeft, j - 1, t - countLeft, t - countRight - 1));
        } else {
            //左、右子树不为null
            root.setLeft(buildTreeByPostOrderAndInOrder(postOrder, inOrder, i, i + countLeft - 1, s, s + countLeft - 1));
            root.setRight(buildTreeByPostOrderAndInOrder(postOrder, inOrder, j - 1 - countRight + 1, j - 1, t - countRight + 1, t));
        }


        return root;
    }

    public int size(){
        return preOrderTraverseWithoutRecursion(this).size();
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10,
                new BinaryTreeNode(20, new BinaryTreeNode(19, new BinaryTreeNode(12), new BinaryTreeNode(17)), new BinaryTreeNode(18)),
                new BinaryTreeNode(9, new BinaryTreeNode(6, new BinaryTreeNode(0), new BinaryTreeNode(7, new BinaryTreeNode(1), null)), new BinaryTreeNode(8)));
        int n = root.size();
        System.out.println((Arrays.toString(inOrderTraverseWithoutRecursion(root).toArray(new Integer[0]))));
        System.out.println((Arrays.toString(postOrderTraverseWithoutRecursion(root).toArray(new Integer[0]))));
        BinaryTreeNode newRoot = buildTreeByPostOrderAndInOrder(postOrderTraverseWithoutRecursion(root).toArray(new Integer[0]),
                inOrderTraverseWithoutRecursion(root).toArray(new Integer[0]), 0, n - 1, 0, n - 1);
        System.out.println(root);
        System.out.println(newRoot);

    }
    /**
     * 输出：
     * [12, 19, 17, 20, 18, 10, 0, 6, 1, 7, 9, 8]
     * [12, 17, 19, 18, 20, 0, 1, 7, 6, 8, 9, 10]
     * BinaryTreeNode{key=10, left=BinaryTreeNode{key=20, left=BinaryTreeNode{key=19, left=BinaryTreeNode{key=12, left=null, right=null}, right=BinaryTreeNode{key=17, left=null, right=null}}, right=BinaryTreeNode{key=18, left=null, right=null}}, right=BinaryTreeNode{key=9, left=BinaryTreeNode{key=6, left=BinaryTreeNode{key=0, left=null, right=null}, right=BinaryTreeNode{key=7, left=BinaryTreeNode{key=1, left=null, right=null}, right=null}}, right=BinaryTreeNode{key=8, left=null, right=null}}}
     * BinaryTreeNode{key=10, left=BinaryTreeNode{key=20, left=BinaryTreeNode{key=19, left=BinaryTreeNode{key=12, left=null, right=null}, right=BinaryTreeNode{key=17, left=null, right=null}}, right=BinaryTreeNode{key=18, left=null, right=null}}, right=BinaryTreeNode{key=9, left=BinaryTreeNode{key=6, left=BinaryTreeNode{key=0, left=null, right=null}, right=BinaryTreeNode{key=7, left=BinaryTreeNode{key=1, left=null, right=null}, right=null}}, right=BinaryTreeNode{key=8, left=null, right=null}}}
     */
}
