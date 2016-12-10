package xin.interview.dictionaryseparatestring;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xin on 8/9/2016.
 */
@Data
public class Node {
    boolean isLeaf;
    Map<Character, Node> nextChar;

    public Node() {
        isLeaf = false;
        nextChar = new HashMap<>();
    }
}
