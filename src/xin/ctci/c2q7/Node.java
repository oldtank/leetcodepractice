package xin.ctci.c2q7;

import lombok.Data;

/**
 * Created by Xin on 8/21/2016.
 */
@Data
public class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }
}
