package xin.leetcode.simplifypath_71;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by Xin on 10/6/2016.
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i=1; i<tokens.length; i++) {
            if (tokens[i].equals("") || tokens[i].equals(".")) {
                continue;
            }
            if (tokens[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(tokens[i]);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.removeFirst());
        }
        return sb.toString();
    }
}