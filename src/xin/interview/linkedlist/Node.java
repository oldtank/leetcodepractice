package xin.interview.linkedlist;

import lombok.Data;

/**
 * Created by Xin on 11/18/2016.
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
