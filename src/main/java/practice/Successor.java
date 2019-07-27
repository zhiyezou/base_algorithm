package practice;

public class Successor {

    public static class Node {
        public Node left;
        public Node right;
        public Node parent;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.parent = null;
        head.left = new Node(2);
        head.right = new Node(3);

        head.left.parent = head;
        head.left.left = new Node(4);
        head.left.right = new Node(5);

        head.right.parent = head;
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        head.left.left.parent = head.left;
        head.left.right.parent = head.left;

        head.right.left.parent = head.right;
        head.right.right.parent = head.right;

        printSuccessor(head.right.left);
        printPrecursor(head.right.left);
    }


    public static void printSuccessor(Node node) {
        if (node != null) {
            if (node.right != null) {
                Node cur = node.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                System.out.println(cur.value);
            } else {
                Node parent = node.parent;
                while (parent != null && parent.left != node) {
                    node = node.parent;
                    parent = node.parent;
                }
                System.out.println(node.parent.value);
            }
        }
    }


    public static void printPrecursor(Node node) {
        if (node != null) {
            if (node.left != null) {
                Node cur = node.left;
                while (cur.right != null) {
                    cur = cur.right;
                }
                System.out.println(cur.value);
            } else {
                Node parent = node.parent;
                while (parent != null && parent.right != node) {
                    node = node.parent;
                    parent = node.parent;
                }
                System.out.println(node.parent.value);
            }
        }
    }
}
