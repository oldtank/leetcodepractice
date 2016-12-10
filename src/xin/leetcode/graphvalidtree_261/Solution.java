package xin.leetcode.graphvalidtree_261;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 9/6/2016.
 */
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n==0 || n==1) {
            return true;
        }
        Map<Integer, List<Integer>> linked = new HashMap<>();
        for (int[] edge : edges) {
            linked.putIfAbsent(edge[0], new ArrayList<>());
            linked.putIfAbsent(edge[1], new ArrayList<>());
            linked.get(edge[0]).add(edge[1]);
            linked.get(edge[1]).add(edge[0]);
        }
        boolean visited[] = new boolean[n];
        visited[0] = true;
        boolean isGraph = dfs(0, visited, linked);
        for (int i=0; i<n; i++) {
            isGraph = (isGraph && visited[i]);
        }
        return isGraph;
    }

    public boolean dfs(int curr, boolean[] visited, Map<Integer, List<Integer>> linked) {
        if (linked.get(curr) == null) {
            return true;
        }
        boolean isGraph = true;
        for (int neighbour : linked.get(curr)) {
            if (visited[neighbour]) {
                isGraph=false;
                break;
            } else {
                visited[neighbour] = true;
                linked.get(neighbour).remove(Integer.valueOf(curr));
                isGraph = dfs(neighbour, visited, linked);
            }
        }
        return isGraph;
    }
}