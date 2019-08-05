package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Serial {
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

        // System.out.println(serialByLevel(head));
        //printBinaryTree(deSerial("1_2_4_#_#_5_#_#_3_6_#_#_7_#_#_"), 0, "H");
        //printBinaryTree(deSerialByLever("1_2_3_4_5_6_7_#_#_#_#_#_#_#_#_"), 0, "H");


        System.out.println(inSerial(head));
        System.out.println(inDeSerial("#_4_#_2_#_5_#_1_#_6_#_3_#_7_#_"));
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

    public static String serial(Node head) {
        if (head == null) {
            return "#_";
        }
        String result = head.value + "_";
        result += serial(head.left);
        result += serial(head.right);
        return result;
    }


    public static String serialByLevel(Node head) {
        if (head == null) {
            return "#_";
        }
        String result = head.value + "_";
        Queue<Node> stack = new LinkedList<>();
        stack.offer(head);
        Node cur = head;
        while (!stack.isEmpty()) {
            cur = stack.poll();
            if (cur.left != null) {
                result += cur.left.value + "_";
                stack.offer(cur.left);
            } else {
                result += "#_";
            }
            if (cur.right != null) {
                result += cur.right.value + "_";
                stack.offer(cur.right);
            } else {
                result += "#_";
            }

        }
        return result;
    }

    public static Node deSerialByLever(String str) {
        String[] strs = str.split("_");
        Node head = new Node(Integer.valueOf(strs[0]));

        Queue<String> queue = new LinkedList<>();
        for (int i = 1; i < strs.length; i++) {
            queue.offer(strs[i]);
        }

        Queue<Node> tmp = new LinkedList<>();
        tmp.offer(head);
        while (!tmp.isEmpty()) {
            Node cur = tmp.poll();
            String left = queue.poll();
            // System.out.println(left);
            cur.left = left.equals("#") ? null : new Node(Integer.valueOf(left));
            String right = queue.poll();
            // System.out.println(right);
            cur.right = right.equals("#") ? null : new Node(Integer.valueOf(right));

            if (cur.left != null) {
                tmp.offer(cur.left);
            }
            if (cur.right != null) {
                tmp.offer(cur.right);
            }
        }

        return head;

    }

    public static Node deSerial(String str) {
        String[] strs = str.split("_");

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            queue.offer(strs[i]);
        }
        return realDeSerial(queue);
    }

    public static Node realDeSerial(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = realDeSerial(queue);
        head.right = realDeSerial(queue);
        return head;
    }

    public static String inSerial(Node head) {
        if (head == null) {
            return "#_";
        }

        String res = "";
        res += inSerial(head.left);
        res += head.value + "_";
        res += inSerial(head.right);
        return res;
    }

    public static Node inDeSerial(String s) {
        Queue<String> queue = new LinkedList<>();
        for (String str : s.split("_")) {
            queue.offer(str);
        }
        return inRealDeSerial(queue);
    }

    public static Node inRealDeSerial(Queue<String> queue) {
        String str = queue.poll();
        Node head = new Node(1);
        if (str.equals("#")) {
            return null;
        }
        head.left = inRealDeSerial(queue);
        head = new Node(Integer.valueOf(str));
        head.right = inRealDeSerial(queue);
        return head;


    }

    /*public static String seLevel(Node head) {
    }*/
}
