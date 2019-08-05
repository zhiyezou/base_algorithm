package practice;

import java.util.Stack;

public class BalanceSearchTree {
    public static void main(String[] args) {
        Node head = new Node(6);
        head.left = new Node(4);
        head.right = new Node(9);
        head.left.left = new Node(2);
        head.left.right = new Node(5);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        System.out.println(in(head));
    }

    public static boolean in(Node head) {
        boolean flag = true;
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Node cur = head;
            int min = Integer.MIN_VALUE;
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    System.out.println(cur.value);
                    if (cur.value > min) {
                        min = cur.value;
                    } else {
                        return false;
                    }
                    cur = cur.right;
                }
            }
        }
        return flag;
    }

    public static class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printBinaryTree(Node head, int height, String flag) {
        if (head == null) {
            return;
        }
        printBinaryTree(head.right, height + 1, "v");
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < height * 15; i++) {
            stringBuffer.append(" ");
        }
        System.out.println(stringBuffer + flag + head.value + flag);
        printBinaryTree(head.left, height + 1, "^");
    }
}
