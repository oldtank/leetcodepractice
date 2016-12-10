package xin.disjointset;

import lombok.Data;

/**
 * Created by Xin on 8/11/2016.
 */
@Data
public class Element {
    private Element next;
    private String value;
    private DisjointSet disjointSet;

    public Element(String value) {
        this.value = value;
        next = null;
        disjointSet = null;
    }

    public Element findSetRep() {
        return disjointSet.getHead();
    }
}
