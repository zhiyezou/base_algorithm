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

        System.out.println(printNext(head.right.right).value);
    }

    public static Node printNext(Node node) {
        if (node.right != null) {
            return getLeft(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeft(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
