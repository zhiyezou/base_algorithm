package practice;

public class CompleteTreeNum {
    public static class Node {
        public Node left;
        public Node right;
        int value;

        public Node(int value) {
            this.value = value;
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

        System.out.println(getTreeNum(head));
        System.out.println(nodeNum(head, getTreeHeight(head)));
        //System.out.println(1 << 3);
    }

    public static int getTreeNum(Node head) {
        if (head == null) {
            return 0;
        }

        int num = 0;

        int lh = getTreeHeight(head.left);
        int rh = getTreeHeight(head.right);
        if (lh == rh) {
            num += 1 << lh;
            num += getTreeNum(head.right);
        }

        if (lh > rh) {
            num += 1 << rh;
            num += getTreeNum(head.left);
        }
        return num;
    }

    public static int getTreeHeight(Node head) {
        int i = 1;
        if (head == null) {
            return 0;
        }
        while (head.left != null) {
            i++;
            head = head.left;
        }
        return i;
    }

    public static int nodeNum(Node head, int ha) {
        if (head == null) {
            return 0;
        }

        int rh = getTreeHeight(head.right);
        if (rh == ha) {
            return (1 << ha) + nodeNum(head.right, ha);
        } else {
            return (1 << rh) + nodeNum(head.left, ha);
        }

    }
}
