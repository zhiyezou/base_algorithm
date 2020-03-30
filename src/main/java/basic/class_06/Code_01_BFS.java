package basic.class_06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历图的方式，是以一种类似波纹扩散的方式进行的，不断放大辐射半径，进而覆盖整张图。
 * <p>
 * 队列实现
 * 1.选择起始顶点放入队列，并标记为已访问；
 * 2.当队列不为空时，从队列中取出顶点作为目标顶点，将目标顶点的所有相邻且未被访问过的顶点放入队列，并标记为已访问；
 * 3.重复执行步骤 2。
 * <p>
 * 1.利用队列实现
 * 2.从源节点开始依次按照宽度进队列，然后弹出
 * 3.每弹出一个点，把该节点所有没有进过队列的邻接点放入队列
 * 4.直到队列为空
 */
public class Code_01_BFS {

    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> map = new HashSet<>();
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!map.contains(next)) {
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }

}
