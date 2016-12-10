package xin.leetcode.minimumheighttree_310;

import java.util.*;

/**
 * Created by Xin on 9/7/2016.
 */
public class Solution {
    public List<Integer> findMHT(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        if (n==0) {
            return list;
        }
        if (n==1) {
            list.add(0);
            return list;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            graph.putIfAbsent(edge[0], new LinkedList<>());
            graph.putIfAbsent(edge[1], new LinkedList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        while(graph.keySet().size() > 2) {
            List<Integer> leaves = new ArrayList<>();
            for (Integer from : graph.keySet()) {
                if (graph.get(from).size() == 1){
                    leaves.add(from);
                }
            }
            for (Integer leave: leaves) {
                graph.get(graph.get(leave).get(0)).remove(leave);
                graph.remove(leave);

            }
        }
        for (Integer from : graph.keySet()) {
            list.add(from);
        }
        return list;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int graph[][] = new int[n][n];
        for (int[] edge: edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        System.out.println(height(n, graph, 4));
        return new ArrayList<>();
    }

    private int height(int n, int[][] graph, int root) {
        int h=0;
        for (int i=0; i<n; i++) {
            if (graph[root][i] == 1) {
                graph[root][i] = 0;
                graph[i][root] =0;
                h = Math.max(h, height(n, graph, i));
            }
        }
        return h+1;
    }
}