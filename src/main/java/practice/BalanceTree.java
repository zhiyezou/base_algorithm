package practice;

public class BalanceTree {
    public static class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class ReturnData {
        public boolean isB;
        public int h;

        public ReturnData(boolean isB, int h) {
            this.h = h;
            this.isB = isB;
        }
    }

    public static ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(true, 0);
        }

        ReturnData left = process(head.left);
        if (!left.isB) {
            return new ReturnData(false, 0);
        }

        ReturnData right = process(head.right);
        if (!right.isB) {
            return new ReturnData(false, 0);
        }

        if (Math.abs(left.h - right.h) > 1) {
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(right.h, left.h) + 1);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        //head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        //head.right.left = new Node(6);
        //head.right.right = new Node(7);
        System.out.println(process(head).isB);
    }
}
