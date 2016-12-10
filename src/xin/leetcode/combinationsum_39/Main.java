package xin.leetcode.combinationsum_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xin on 8/28/2016.
 */
public class Main {
    public static void main(String[] args) {
        int  candidates[] = {2,3,6,7};
        int target = 7;
        System.out.println(new Solution().combinationSum(candidates, target));
//        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationHelper(candidates, target, 0);
    }

    public static List<List<Integer>> combinationHelper(int[] candidates, int target, int pos) {
        if (candidates[pos] > target) {
            return new ArrayList<>();
        } else if (candidates[pos] == target) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(target);
            lists.add(list);
            return lists;
        } else {
            List<List<Integer>> combinations = new ArrayList<>();
            for (int i=pos; i<candidates.length && candidates[i] <= target; i++) {
                if (candidates[i] < target) {
                    List<List<Integer>> subCombinations = combinationHelper(candidates, target - candidates[i], i);
                    for (int j = 0; j < subCombinations.size(); j++) {
                        subCombinations.get(j).add(candidates[i]);
                        combinations.add(subCombinations.get(j));
                    }
                } else if (candidates[i] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(target);
                    combinations.add(list);
                }
            }
            return combinations;
        }
    }
}
