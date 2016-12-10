package xin.leetcode.binarytreelongestconsecutivesequence_298;

import java.util.List;
import java.util.Stack;

/**
 * Created by Xin on 8/31/2016.
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }

    public int helper(TreeNode root, TreeNode parent, int length) {
        if (root == null) {
            return length;
        }
        length = (parent != null && root.val == parent.val +1) ? length+1:1;
        return Math.max(length, Math.max(helper(root.left, root, length), helper(root.right, root, length)));
    }

    public class Result {
        int max;
    }
}
