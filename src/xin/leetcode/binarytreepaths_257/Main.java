package xin.leetcode.binarytreepaths_257;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.Pack200;

/**
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]

 https://leetcode.com/problems/binary-tree-paths/
 */
public class Main {

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<String> leftSub = binaryTreePaths2(root.left);
        List<String> rightSub = binaryTreePaths2(root.right);
        if (leftSub.isEmpty() && rightSub.isEmpty()) {
            paths.add(root.val+"");
        } else {
            leftSub.forEach(s -> {
                paths.add(root.val+"->"+s);
            });
            rightSub.forEach(s -> {
                paths.add(root.val+"->"+s);
            });
        }
        Set<String> set = new HashSet<>();
        return paths;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helper(root, sb, list);
        return list;
    }

    public void helper(TreeNode root, StringBuilder sb, List<String> list ) {
        if (root.left == null && root.right == null) {
            list.add(sb.append(root.val).toString());
            sb.delete(sb.length() - (""+root.val).length(), sb.length());
            return;
        }
        sb.append(root.val).append("->");
        if (root.left != null) {
            helper(root.left, sb, list);
        }
        if (root.right != null) {
            helper(root.right, sb, list);
        }
        sb.delete(sb.length() - (root.val+"->").length(), sb.length());
    }
}
