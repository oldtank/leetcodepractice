package xin.leetcode.combinationsum_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xin on 10/18/2016.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int pos, int target, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(list);
            return;
        }
        for (int i=pos; i<candidates.length; i++) {
            if (candidates[i] <= target) {
                List<Integer> l = new ArrayList<>(list);
                l.add(candidates[i]);
                helper(candidates, i, target - candidates[i], l, result);
            }
        }
    }
}