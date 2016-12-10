package xin.datastructure.avltree;

import lombok.Data;

/**
 * Created by Xin on 7/26/2016.
 */
@Data
public class Node<T extends Comparable> {
    T value;
    Node left;
    Node right;
    int height;

    public Node(T value) {
        this.value = value;
        left = null;
        right = null;
        height = 1;
    }
}
