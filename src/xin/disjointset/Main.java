package xin.disjointset;

/**
 * Created by Xin on 8/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        Element f = new Element("f");
        Element g = new Element("g");
        Element d = new Element("d");
        Element c = new Element("c");
        Element h = new Element("h");

        DisjointSet setf = new DisjointSet(f);
        DisjointSet setg = new DisjointSet(g);
        DisjointSet setd = new DisjointSet(d);
        DisjointSet setc = new DisjointSet(c);
        DisjointSet seth = new DisjointSet(h);

        Graph.unionSet(setf, setg);
        DisjointSet unionSet = Graph.unionSet(f, d);
        System.out.println(Graph.sameSet(f, d));
        System.out.println(Graph.sameSet(f, h));
        unionSet.printMe();
        DisjointSet unionSet2 = Graph.unionSet(c, h);
        unionSet2.printMe();
        Graph.unionSet(f, h);
        System.out.println(Graph.sameSet(f, h));
        f.getDisjointSet().printMe();
        System.out.println(f.getDisjointSet().getCount());
    }

}
