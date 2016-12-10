package xin.interview.stringtotree;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by Xin on 8/21/2016.
 */
@Data
public class Node {
    private int value;
    private ArrayList<Node> children;
    private Node parent;

    public Node() {
        parent = null;
        children = new ArrayList<>();
    }

    public Node(int value) {
        this.value = value;
        children = new ArrayList<>();
        parent = null;
    }

    public void print() {
        print(this);
    }

    public void print(Node curr) {
        if (curr == null) {
            return;
        }
        System.out.print("(" + curr.getValue());
        curr.getChildren().forEach(child -> print(child));
        System.out.print(")");
    }
}
