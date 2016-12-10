package xin.ctci.c4q5;

import lombok.Data;

/**
 * Created by Xin on 8/22/2016.
 */
@Data
public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
