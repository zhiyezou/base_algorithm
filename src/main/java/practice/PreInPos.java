package practice;

import java.util.Stack;

public class PreInPos {

    public static class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void Pre(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node cur = head;
            while (!stack.isEmpty()) {
                cur = stack.pop();
                System.out.println(cur.value);
                if (cur.right != null) {
                    stack.push(cur.right);
                }

                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return;
    }

    public static void In(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Node cur = head;
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    System.out.println(cur.value);
                    cur = cur.right;
                }
            }
        }
    }

    public static void Pos(Node head) {
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            Node cur = head;
            while (!stack1.isEmpty()) {
                cur = stack1.pop();
                stack2.push(cur);

                if (cur.left != null) {
                    stack1.push(cur.left);
                }

                if (cur.right != null) {
                    stack1.push(cur.right);
                }
            }

            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value);
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        Pre(head);
        //In(head);
        //Pos(head);
    }
}
