package xin.leetcode.subsets_78;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 https://leetcode.com/problems/subsets/
 */
public class Main {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(result, nums, 0, new ArrayList<>());
        return result;
//        return subsetsHelper(nums, 0, nums.length-1);
    }

    public static void helper(List<List<Integer>> result, int[] nums, int pos, List<Integer> curr)
    {
        if (pos == nums.length) {
            result.add(curr);
            return;
        }

        List<Integer> copy = new ArrayList<>();
        copy.addAll(curr);
        copy.add(nums[pos]);
        helper(result, nums, pos+1, copy);

        helper(result, nums, pos+1, curr);
    }

    public static List<List<Integer>> subsetsHelper(int[] nums, int start, int end) {
        if (start == end) {
            List<List<Integer>> subsets = new ArrayList<>();
            subsets.add(new ArrayList<>());
            List<Integer> oneElementList = new ArrayList<>();
            oneElementList.add(nums[start]);
            subsets.add(oneElementList);
            return subsets;
        }

        List<List<Integer>> subsets = new ArrayList<>();
        List<List<Integer>> front_subsets = subsetsHelper(nums, start, end-1);
        subsets.addAll(front_subsets);
        for (List<Integer> front_subset : front_subsets) {
            List<Integer> list = new ArrayList<>(front_subset);
            list.add(nums[end]);
            subsets.add(list);
        }
        return subsets;
    }
}
