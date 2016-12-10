package xin.ctci.c2q3;

import lombok.Data;

/**
 * Created by Xin on 8/20/2016.
 */
@Data
public class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }
}
