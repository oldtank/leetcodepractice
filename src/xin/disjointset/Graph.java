package xin.disjointset;

/**
 * Created by Xin on 8/11/2016.
 */
public class Graph {
    public static DisjointSet unionSet(Element e1, Element e2) {
        return unionSet(e1.getDisjointSet(), e2.getDisjointSet());
    }

    public static DisjointSet unionSet(DisjointSet set1, DisjointSet set2) {
        set1.getTail().setNext(set2.getHead());
        Element elementInSet2 = set2.getHead();
        while (elementInSet2 != null) {
            elementInSet2.setDisjointSet(set1);
            elementInSet2 = elementInSet2.getNext();
        }
        set1.setTail(set2.getTail());
        set1.setCount(set1.getCount() + set2.getCount());
        set2 = null;
        return set1;
    }

    public static boolean sameSet(Element e1, Element e2) {
        return e1.getDisjointSet() == e2.getDisjointSet();
    }
}
