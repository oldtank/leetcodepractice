package xin.leetcode.sumofleftleaves_404;

/**
 * Created by Xin on 10/4/2016.
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, false);
    }

    int helper(TreeNode curr, boolean isLeftChild) {
        if (curr == null) {
            return 0;
        }

        if (curr.left == null && curr.right == null) {
            if (isLeftChild) {
                return curr.val;
            } else {
                return 0;
            }
        }
        return helper(curr.left, true) + helper(curr.right, false);
    }
}