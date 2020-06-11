package basic.class_04;

/**
 * 在二叉树中找到一个节点的后续节点
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
 * 假设有一颗Node类型节点组成的二叉树，树种每个节点的parent指针都正确的指向自己的父亲节点，头节点指向null。
 * 只给一个在二叉树中的某个节点node，请实现返回node后续节点的函数。
 * <p>
 * 在二叉树的中序遍历中，node的下一个节点叫作node的后继节点。
 * <p>
 * 两种方式：
 * 1.给定一个节点，你肯定可以根据parent的指针找到头节点，然后玩儿一个二叉树的中序遍历，生成一个序列，看当前节点的下一个节点是啥。
 * 但是，这样做需要遍历整棵树，复杂度比较高。
 * 2.给定一个节点，复杂度等于当前节点到后继节点的长度。避免遍历整棵树。
 * <p>
 * 正解：
 * 既然后继节点就是中序遍历中的下一个节点，中序遍历是先左，再中，再右，如果一个节点有右子树，如果当前节点打印了，那么下一个节点是谁呀？
 * 右子树最左边的节点，
 * <p>
 * 如果一个节点它有右子树，弄完当前节点后一定会去弄它的右子树。那么在右子树上打印的第一个节点是什么呢，整体顺序是先左中右的，那么右子树上下一个
 * 打印的节点一定是整棵右子树中最左的节点。
 * 1.给定一个节点，如果他有右孩子，他的后继节点一定是他右子树上最左的节点。（就考虑中序遍历过程中，当前节点打印了，那么下一个他会打印谁）
 * 2.给定一个节点，如果他无右孩子(哪个节点的左子树是以当前节点结尾的)，通过当前节点的父指针，找到它的父亲节点，如果我发现当前节点是这个父亲节点的右孩子，那就继续往上，直到当前节点是它父亲节点的左孩子停止，后继节点是这个父节点。
 */
public class Code_03_SuccessorNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {//如果parent为空，证明这个节点就没有后继。
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }

}
