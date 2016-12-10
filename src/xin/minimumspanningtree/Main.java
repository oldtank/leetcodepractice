package xin.minimumspanningtree;

/**
 * Created by Xin on 8/18/2016.
 */
public class Main {
    public static void main(String[] args) {
//        Graph g = new Graph();
//        addVertices(g);
//        connectGraph(g);
//        System.out.println(g.findPathBFS("b", "g    "));
        int i = -5;
        System.out.println(i%3);
    }

    public static void addVertices(Graph g) {
        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("d");
        g.addVertex("e");
        g.addVertex("f");
        g.addVertex("g");
        g.addVertex("h");
        g.addVertex("i");
    }

    public static void connectGraph(Graph g) {
        g.connect("a", "b", 4, false);
        g.connect("b", "c", 8, false);
        g.connect("d", "c", 7, false);
        g.connect("d", "e", 9, false);
        g.connect("c", "i", 2, false);
        g.connect("c", "f", 4, false);
        g.connect("h", "g", 1, false);
        g.connect("f", "g", 2, false);
    }
}

