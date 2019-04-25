package practice;

import java.util.HashSet;

public class ListHardest {

    public static class Node {
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node isCombine1(Node head1, Node head2) {
        HashSet<Node> set = new HashSet<>();
        Node entry = null;
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (set.contains(head2)) {
                return head2;
            }
            head2 = head2.next;
        }

        return entry;
    }

    public static Node isCombine2(Node head1, Node head2) {
        Node entry = null;
        int len1 = 0;
        int len2 = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != null) {
            len1 += 1;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            len2 += 1;
            cur2 = cur2.next;
        }

        boolean flag = true;
        flag = len1 - len2 >= 0 ? true : false;
        if (flag) {
            for (int i = 0; i < len1 - len2; i++) {
                head1 = head1.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return entry;
    }

    public static Node isCircle2(Node head) {
        Node entry = null;
        Node slow = head;
        Node fast = head;
        do {
            if (fast.next == null || fast.next.next == null) {
                return entry;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node isCircle1(Node head) {
        HashSet<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    public static Node getfirst(Node head1, Node loop1, Node head2, Node loop2) {
        Node entry = null;
        Node cur1 = head1;
        Node cur2 = head2;
        if (loop1 == loop2) {
            int len1 = 0;
            int len2 = 0;

            while (cur1 != loop1) {
                len1 += 1;
                cur1 = cur1.next;
            }

            while (cur2 != loop2) {
                len2 += 1;
                cur2 = cur2.next;
            }

            boolean flag = true;
            flag = len1 - len2 >= 0 ? true : false;
            if (flag) {
                for (int i = 0; i < len1 - len2; i++) {
                    head1 = head1.next;
                }
            } else {
                for (int i = 0; i < len2 - len1; i++) {
                    head2 = head2.next;
                }
            }

            while (head1 != loop1) {
                if (head1 == head2) {
                    return head1;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
            System.out.println("uuuuu");
            return entry;
        } else {
            System.out.println("sssss");
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
        }
        return entry;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = head1.next.next;

        Node head2 = new Node(5);
        head2.next = head1.next.next;

        Node entry = isCircle1(head1);
        entry = isCircle1(head2);
        entry = getfirst(head1, isCircle1(head1), head2, isCircle2(head2));
        System.out.println(entry == null ? null : entry.value);

    }
}
