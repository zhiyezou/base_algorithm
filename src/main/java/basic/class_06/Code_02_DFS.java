package basic.class_06;

import java.util.HashSet;
import java.util.Stack;

/**
 * 相对于广度优先访问，深度优先的方式更像是一条路走到黑，走不下去了再回到上个路口选择另外一条路。
 * <p>
 * 1.利用栈实现
 * 2.从源节点开始把节点按照深度放入栈，然后弹出
 * 3.每弹出一个点，把该节点及下一个没有进过站的邻接点放入栈
 * 4.直到栈变空
 */
public class Code_02_DFS {

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

}
