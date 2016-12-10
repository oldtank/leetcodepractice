package xin.graph;

import java.util.*;

/**
 * Created by Xin on 8/17/2016.
 */
public class Graph {
    ArrayList<Vertex> vertices;
    HashMap<Vertex, LinkedList<Vertex>> connections;
    public Graph() {
        vertices = new ArrayList<>();
        connections = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public void connect(Vertex u, Vertex v, boolean directed) {
        connectHelper(u, v);

        if (directed) {
            connectHelper(v, u);
        }
    }

    private void connectHelper(Vertex u, Vertex v) {
        if (connections.get(u) == null) {
            connections.put(u, new LinkedList<>());
        }
        connections.get(u).add(v);
    }

    public void breadthFirst(Vertex root) {
        HashMap<Vertex, VisitStatus> visitStatuses = new HashMap<>();
        Queue<Vertex> queue = new ArrayDeque<>();
        vertices.forEach(vertex -> visitStatuses.put(vertex, VisitStatus.WHITE));

        visitStatuses.put(root, VisitStatus.GRAY);
        queue.offer(root);

        while(!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.println("visiting: " + current.getValue());
            connections.get(current)
                    .stream()
                    .filter(linked -> visitStatuses.get(linked) == VisitStatus.WHITE)
                    .forEach(linked -> {
                        visitStatuses.put(linked, VisitStatus.GRAY);
                        queue.offer(linked);
                    });
            visitStatuses.put(current, VisitStatus.BLACK);
        }
    }

    public void depthFirst(Vertex root) {
        HashMap<Vertex, VisitStatus> visitStatuses = new HashMap<>();
        vertices.forEach(vertex -> visitStatuses.put(vertex, VisitStatus.WHITE));
        depthFirstVisit(root, visitStatuses, 0);
    }

    private void depthFirstVisit(Vertex root, HashMap<Vertex, VisitStatus> visitStatus, int distance) {
        visitStatus.put(root, VisitStatus.GRAY);
        System.out.print("("+root.getValue());
        connections.get(root)
                .stream()
                .filter(linked -> visitStatus.get(linked) == VisitStatus.WHITE)
                .forEach(linked -> depthFirstVisit(linked, visitStatus, distance + 1));

        visitStatus.put(root, VisitStatus.BLACK);
        System.out.print(root.getValue()+")");
    }

    public int countNumOfPaths(Vertex from, Vertex to) {
        to.setNumOfPaths(1);
        HashMap<Vertex, VisitStatus> visitStatuses = new HashMap<>();
        vertices.forEach(vertex -> visitStatuses.put(vertex, VisitStatus.WHITE));
        countNumOfPathsHelper(from, to, visitStatuses);
        return from.getNumOfPaths();
    }

    public void countNumOfPathsHelper(Vertex from, Vertex to, HashMap<Vertex, VisitStatus> visitStatus) {
        visitStatus.put(from, VisitStatus.GRAY);
        connections.get(from)
                .stream()
                .forEach(linked -> {
                    if (linked == to && visitStatus.get(linked) != VisitStatus.BLACK) {
                        visitStatus.put(to, VisitStatus.BLACK);
                    } else {
                        if (visitStatus.get(linked) == VisitStatus.WHITE) {
                            countNumOfPathsHelper(linked, to, visitStatus);
                        }
                    }
                });
        visitStatus.put(from, VisitStatus.BLACK);
        from.setNumOfPaths(connections.get(from).stream().mapToInt(Vertex::getNumOfPaths).sum());
    }

    public LinkedList<Vertex> findPath(Vertex from, Vertex to) {
        HashMap<Vertex, VisitStatus> visitStatus = new HashMap<>();
        vertices.forEach(vertex -> visitStatus.put(vertex, VisitStatus.WHITE));
        LinkedList<Vertex> path = new LinkedList<>();

        findPathHelper(from, to, visitStatus, path);
        return path;
    }

    public void findPathHelper(Vertex from, Vertex to, HashMap<Vertex, VisitStatus> visitStatus, LinkedList<Vertex> path) {
        visitStatus.put(from, VisitStatus.GRAY);
        if (from == to) {
            path.addFirst(from);
            return;
        }
        for (Vertex linked : connections.get(from)) {
            if (visitStatus.get(linked) == VisitStatus.WHITE) {
                findPathHelper(linked, to, visitStatus, path);
                if (path != null && !path.isEmpty()) {
                    break;
                }
            }
        }

        visitStatus.put(from, VisitStatus.BLACK);
        if (path != null && !path.isEmpty()) {
            path.addFirst(from);
            return;
        }
    }
}
