package xin.leetcode.clonegraph_133;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/1/2016.
 */
class UndirectedGraphNode {
    int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
};