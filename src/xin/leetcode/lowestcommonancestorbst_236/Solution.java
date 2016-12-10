package xin.leetcode.lowestcommonancestorbst_236;

import xin.leetcode.binarysearchtreeiterator_173.TreeNode;

/**
 * Created by Xin on 11/26/2016.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result result = helper(root, p, q);
        if (result.isAncestor) {
            return result.node;
        }
        return null;
    }

    public Result helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root == p && root == q) {
            return new Result(root, true);
        }
        Result rleft = helper(root.left, p, q);
        if (rleft.isAncestor) {
            return rleft;
        }
        Result rRight = helper(root.right, p, q) ;
        if (rRight.isAncestor) {
            return rRight;
        }
        if (rleft.node != null && rRight.node != null) {
            return new Result(root, true);
        } else if (root == p || root == q) {
            boolean isAncestor = rleft.node != null || rRight.node != null ? true : false;
            return new Result(root, isAncestor);
        } else {
            return new Result(rleft.node != null ? rleft.node : rRight.node, false);
        }
    }

    public class Result {
        TreeNode node;
        boolean isAncestor;
        public Result(TreeNode n, boolean isAncestor) {
            node = n;
            this.isAncestor = isAncestor;
        }
    }
}
