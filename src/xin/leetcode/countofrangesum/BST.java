package xin.leetcode.countofrangesum;

/**
 * Created by Xin on 9/18/2016.
 */
public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public TreeNode insert(int v) {
        if (root == null) {
            root = new TreeNode(v);
            return root;
        } else {
            insert(root, v);
            return root;
        }
    }

    public TreeNode insert(TreeNode curr, int v) {
        if (curr == null) {
            return new TreeNode(v);
        }

        if (curr.val == v) {
            curr.count++;
        } else if (curr.val > v) {
            curr.leftCount++;
            curr.left = insert(curr.left, v);
        } else {
            curr.rightCount++;
            curr.right = insert(curr.right, v);
        }
        return curr;
    }

    public int rangeSize(TreeNode curr, int lower, int upper) {
        int total = curr.leftCount + curr.count + curr.rightCount;
        int lowerCount = countSmaller(curr, lower);
        int upperCount = countLarger(curr, upper);

        return total-lowerCount-upperCount;
    }

    public int countSmaller(TreeNode curr, int v) {
        if (curr == null) {
            return 0;
        } else if (curr.val == v) {
            return curr.leftCount;
        } else if (curr.val < v) {
            return curr.leftCount + curr.count + countSmaller(curr.right, v);
        } else {
            return countSmaller(curr.left, v);
        }
    }

    public int countLarger(TreeNode curr, int v) {
        if (curr == null) {
            return 0;
        } else if (curr.val == v) {
            return curr.rightCount;
        } else if (curr.val < v) {
            return countLarger(curr.right, v);
        } else {
            return curr.rightCount + curr.count + countLarger(curr.left, v);
        }
    }
}
