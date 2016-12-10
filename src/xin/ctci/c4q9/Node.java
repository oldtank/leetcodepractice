package xin.ctci.c4q9;

import lombok.Data;

/**
 * Created by Xin on 8/22/2016.
 */
@Data
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
