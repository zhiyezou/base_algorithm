package basic.class_04;

/**
 * 二叉树问题，套路：递归函数很好用，可以回到节点三次，想办法收集左右子树的信息，拿过来之后做判断
 * 平衡二叉树：
 * 在这棵树中任何一个节点，它左子树和右子树的高度差不超过1
 * <p>
 * 大的思路：以每个节点为头的整棵树都是平衡的
 * <p>
 * 现在遍历到了某个节点X，我怎么去判断X的整棵树是不是平衡的，要收集那些信息
 * （1）左树是否平衡；
 * （2）右边树是否平衡；
 * （3）左树的高度；
 * （4）右树的高度；
 * 判断左树和右树的高度差是否超过1。
 * <p>
 * 1.分析可能性，整理出信息
 * 2.设计递归返回结构，两个信息：左树是否平衡，左树高度
 * <p>
 * 二叉树的平衡性是解决的效率问题，平衡性很重要
 */
public class Code_06_IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public static int getHeight(Node head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));
        System.out.println(isB(head));

    }


    //====

    public static class ReturnData {
        public boolean isB;
        public int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    public static boolean isB(Node head) {
        return process(head).isB;
    }

    public static ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(true, 0);
        }

        ReturnData leftData = process(head.left);
        if (!leftData.isB) {
            return new ReturnData(false, 0);
        }

        ReturnData rightData = process(head.right);

        if (!leftData.isB) {
            return new ReturnData(false, 0);
        }

        if (Math.abs(leftData.h - rightData.h) > 1) {
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
    }
}
