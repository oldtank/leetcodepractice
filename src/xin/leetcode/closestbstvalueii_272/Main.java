package xin.leetcode.closestbstvalueii_272;

/**
 * Created by Xin on 9/19/2016.
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        double target = 4.8;
        int k = 1;
        System.out.println(new Solution().closestKValues(root, target, k));
    }
}
