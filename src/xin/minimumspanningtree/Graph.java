package xin.minimumspanningtree;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Xin on 8/18/2016.
 */
@Data
public class Graph {
    ArrayList<String> vertices;
    HashMap<String, LinkedList<VertexContainer>> connections;

    public Graph() {
        vertices = new ArrayList<>();
        connections = new HashMap<>();
    }

    public void addVertex(String v) {
        vertices.add(v);
    }

    public void connect(String u, String v, int weight, boolean directed) {
        connectOneDirection(u, v, weight);
        if (!directed) {
            connectOneDirection(v, u, weight);
        }
    }

    private void connectOneDirection(String u, String v, int weight) {
        VertexContainer vc = new VertexContainer(v, weight);
        connections.putIfAbsent(u, new LinkedList<>());
        connections.get(u).add(vc);
    }

    public ArrayDeque<String> findPathBFS(String u, String v) {
        HashMap<String, VisitStatus> visitStatus = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
        vertices.forEach(vertex -> visitStatus.put(vertex, VisitStatus.WHITE));
        ArrayDeque<String> queue = new ArrayDeque<>();
        visitStatus.put(u, VisitStatus.GRAY);
        queue.push(u);
        parent.put(u, "");
        while (!queue.isEmpty()) {
            String current = queue.pop();
            for (VertexContainer vertexContainer : connections.get(current)) {
                if (visitStatus.get(vertexContainer.getVertex()) == VisitStatus.WHITE) {
                    visitStatus.put(vertexContainer.getVertex(), VisitStatus.GRAY);
                    parent.put(vertexContainer.getVertex(), current);
                    if (vertexContainer.getVertex().equals(v)) {
                        break;
                    } else {
                        queue.push(vertexContainer.getVertex());
                    }
                }
            }
        }

        ArrayDeque<String> path = new ArrayDeque<>();
        String curr = v;
        while (!curr.equals("")) {
            path.addFirst(curr);
            curr = parent.get(curr);
        }
        return path;
    }
}
