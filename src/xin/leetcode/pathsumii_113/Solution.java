package xin.leetcode.pathsumii_113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 10/8/2016.
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        helper(root, sum, new ArrayList<>(), paths);
        return paths;
    }

    void helper(TreeNode curr, int sum, List<Integer> path, List<List<Integer>> paths) {
        if (curr == null) {
            return;
        }
        if (curr.left == null && curr.right == null && curr.val == sum) {
            List<Integer> p = new ArrayList<>();
            p.addAll(path);
            p.add(curr.val);
            paths.add(p);
        }
        path.add(curr.val);
        helper(curr.left, sum - curr.val, path, paths);
        helper(curr.right, sum - curr.val, path, paths);
        path.remove(path.size()-1);
    }
}