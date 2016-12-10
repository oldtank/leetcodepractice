package xin.leetcode.binarysearchtreeiterator_173;

import java.util.Stack;

/**
 * Created by Xin on 9/2/2016.
 */
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack =  new Stack<>();
        pushToStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode n = stack.pop();
        pushToStack(n.right);
        return n.val;
    }

    public void pushToStack(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}