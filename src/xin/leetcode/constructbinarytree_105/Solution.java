package xin.leetcode.constructbinarytree_105;

/**
 * Created by Xin on 8/28/2016.
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int pre_left, int pre_right, int[] inorder, int in_left, int in_right) {
        if (pre_left == pre_right) {
            TreeNode node = new TreeNode(preorder[pre_left]);
            node.left = null;
            node.right = null;
            return node;
        }
        //first node in pre-order is the root;
        TreeNode root = new TreeNode(preorder[pre_left]);
        //look for root in in-order list
        int found_in_inorder = find(inorder, in_left, in_right, root.val);
        if (found_in_inorder == in_left) {
            //all the remaining nodes in inorder list is the right tree of root;
            root.right = buildTree(preorder, pre_left+1, pre_right, inorder, in_left+1, in_right);
        } else if (found_in_inorder == in_right) {
            root.left = buildTree(preorder, pre_left+1, pre_right, inorder, in_left, in_right-1);
        } else {
            int first_right_in_pre = findFirst(preorder, pre_left+1, pre_right, inorder, found_in_inorder+1, in_right);
            root.left = buildTree(preorder, pre_left+1, first_right_in_pre-1, inorder, in_left, found_in_inorder-1);
            root.right = buildTree(preorder, first_right_in_pre, pre_right, inorder, found_in_inorder+1, in_right);
        }
        return root;
    }

    public int find(int[] array, int from, int to, int v) {
        for (int i=from; i<=to; i++) {
            if (array[i] == v) {
                return i;
            }
        }
        return -1;
    }

    public int findFirst(int[] array, int array_from, int array_to, int[] among, int from, int to) {
        for (int i=array_from; i<=array_to; i++) {
            if (find(among, from, to, array[i]) >0) {
                return i;
            }
        }
        return -1;
    }
}