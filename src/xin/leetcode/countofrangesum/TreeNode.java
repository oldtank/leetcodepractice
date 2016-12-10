package xin.leetcode.countofrangesum;

/**
 * Created by Xin on 9/18/2016.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int count;
    int leftCount;
    int rightCount;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;

        count = 1;
        leftCount = 0;
        rightCount = 0;
    }
}
