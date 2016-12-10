package xin.leetcode.combinationsumii_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xin on 11/15/2016.
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, curr, result);
        return result;
    }

    public void helper(int[] candidates, int pos, int target, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(curr);
            return;
        }

        int i = pos;
        while (i < candidates.length) {
            if (candidates[i] > target) {
                break;
            }
            if (i > pos && candidates[i] == candidates[i-1]) {
                i++;
                continue;
            }
            List<Integer> l = new ArrayList<>(curr);
            l.add(candidates[i]);
            helper(candidates, i+1, target - candidates[i], l, result);
            i++;
        }
    }

}
