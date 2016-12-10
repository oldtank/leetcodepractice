package xin.leetcode.inordersuccessorinbst_285;

/**
 * Created by Xin on 10/4/2016.
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode travel = p.right;
            while (travel.left != null) {
                travel = travel.left;
            }
            return travel;
        }

        TreeNode travel = root;
        TreeNode found = null;
        while(travel != p) {
            if (p.val > travel.val) {
                travel = travel.right;
            } else {
                found = travel;
                travel = travel.left;
            }
        }
        return found;
    }
}