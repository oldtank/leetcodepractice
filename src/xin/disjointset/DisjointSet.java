package xin.disjointset;

import lombok.Data;

/**
 * Created by Xin on 8/11/2016.
 */
@Data
public class DisjointSet {
    private Element head;
    private Element tail;
    private int count;

    public DisjointSet() {
        this.count = 0;
        head = null;
        tail = null;
    }

    public DisjointSet(Element e) {
        head = e;
        tail = e;
        count = 1;
        e.setDisjointSet(this);
    }

    public void printMe() {
        Element curr = head;
        while (curr != null) {
            System.out.print(curr.getValue() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }
}
