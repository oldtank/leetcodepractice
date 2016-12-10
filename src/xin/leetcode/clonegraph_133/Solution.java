package xin.leetcode.clonegraph_133;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Xin on 9/1/2016.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> origToCloneMap = new HashMap<>();
        queue.offer(node);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        origToCloneMap.put(node, clone);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            UndirectedGraphNode curr_clone = origToCloneMap.get(curr);
            for (UndirectedGraphNode linked:curr.neighbors) {
                if (origToCloneMap.get(linked) == null) {
                    UndirectedGraphNode linked_clone = new UndirectedGraphNode(linked.label);
                    origToCloneMap.put(linked, linked_clone);
                    curr_clone.neighbors.add(linked_clone);

                    queue.offer(linked);
                } else {
                    UndirectedGraphNode linked_clone = origToCloneMap.get(linked);
                    curr_clone.neighbors.add(linked_clone);
                }
            }
        }
        return clone;
    }
}