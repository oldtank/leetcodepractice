package xin.leetcode.evaluatedivision_399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * equations = [ ["a", "b"], ["b", "c"] ],
 values = [2.0, 3.0],
 queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. .
 */
public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, List<Node>> tree = new HashMap<>();
        for (int i=0; i<equations.length; i++) {
            String a = equations[i][0];
            String b = equations[i][1];
            double v = values[i];
            tree.putIfAbsent(a, new ArrayList<>());
            tree.get(a).add(new Node(b, v));
            tree.putIfAbsent(b, new ArrayList<>());
            tree.get(b).add(new Node(a, 1.0/v));
        }

        double results[] = new double[queries.length];
        for(int i=0; i<queries.length; i++) {
            String from = queries[i][0];
            String to = queries[i][1];
            if (from.equals(to)) {
                results[i] = 1.0;
                continue;
            }
            if (!tree.containsKey(from)) {
                results[i] = -1.0;
                continue;
            }
            LinkedList<String> path = new LinkedList<>();
            HashMap<String, Boolean> visited = new HashMap<>();
            visited.put(from, true);
            TraverseResult r = evaluate(tree, from, to, path, 1.0, visited);

            if (r.found) {
                System.out.println("path found from " + from + " to "+ to);
                path.forEach(s -> System.out.print(s + " "));
                System.out.println("\n" + r.value);
                results[i] = r.value;
            } else {
                System.out.println("path not found from " + from + " to "+ to);
                results[i] = -1.0;
            }
        }
        return results;
    }

    public TraverseResult evaluate(HashMap<String, List<Node>> tree, String from, String dest, LinkedList<String> path, double result, HashMap<String, Boolean> visited) {
        if (from.equals(dest)) {
            path.add(from);
            return new TraverseResult(true, result);
        }
        path.addLast(from);
        List<Node> neighbours = tree.get(from);
        for (Node neighbour : neighbours) {
            if (!visited.containsKey(neighbour.key)) {
                visited.put(neighbour.key, true);
                TraverseResult r = evaluate(tree, neighbour.key, dest, path, result * neighbour.value,visited);
                if (r.found) {
                    return r;
                }
            }
        }

        path.removeLast();
        return new TraverseResult(false, -1.0);
    }

    class TraverseResult {
        boolean found;
        double value;

        public TraverseResult (boolean f, double v) {
            found = f;
            value = v;
        }
    }

    class Node {
        String key;
        double value;

        public Node(String k, double v) {
            key = k;
            value = v;
        }
    }
}