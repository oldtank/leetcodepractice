package xin.graph;

import java.util.LinkedList;

/**
 * Created by Xin on 8/17/2016.
 */
public class Main {
    public static void main(String... args) {
        Graph graph = new Graph();
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);

        graph.connect(a, b, true);
        graph.connect(a, c, true);
        graph.connect(a, d, true);
//        graph.connect(b, e, true);
//        graph.connect(c, e, true);
        graph.connect(c, d, true);
        graph.connect(d, f, true);
        graph.connect(f, e, true);

        LinkedList<Vertex> path = graph.findPath(a, e);
        System.out.println(path);
    }
}
