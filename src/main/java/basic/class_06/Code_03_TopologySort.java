package basic.class_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 决定一件事精先做哪个后做哪个，一件事情被某些事情block主住了，也就是这个事情依赖某些事情，那么整个事情的依赖关系就可以画成一张图。
 * 在这张图里，怎么决定一件事情的先后顺序才能保证当我执行到任何一个事情的时候不被block住，决定这么一个排序的顺序就是拓扑排序。
 * <p>
 * 任何一个位置的点，在做他的时候他条件都已经具备，同一级的排序无所谓。
 * <p>
 * 所有入度为0的顶点，没有任何一个顶点可以到这个顶点，比嗾使他永远是作为from顶点出现，不会作为to顶点出现。
 * 在图上删掉入度为0的顶点，会有新的入度为0的顶点出现。
 * <p>
 * 入度为零的顶点删掉后会产生新的入度为0的节点，依次删，删到最后一个节点。
 * <p>
 * 排序之后，一定是前面指向后面。
 */

public class Code_03_TopologySort {

    // directed graph and no loop
    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
