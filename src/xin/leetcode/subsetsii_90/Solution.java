package xin.leetcode.subsetsii_90;

import java.util.*;

/**
 * Created by Xin on 10/5/2016.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        TreeMap<Integer, Integer> numCount = new TreeMap<>();
        for (int num : nums) {
            numCount.putIfAbsent(num, 0);
            numCount.put(num, numCount.get(num)+1);
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        helper(result, nums, 0, new ArrayList<>());
        return result;
//        return helper(numCount.keySet().toArray(new Integer[0]), numCount, 0);
    }

    private void helper(List<List<Integer>> result, int[] nums, int pos, List<Integer> curr) {
        if (pos == nums.length) {
            result.add(curr);
            return;
        }
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(curr);
        list1.add(nums[pos]);
        helper(result, nums, pos+1, list1);

        int i=pos+1;
        while (i<nums.length && nums[i] == nums[i-1]) {
            i++;
        }
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(curr);
        helper(result, nums, i, list2);
    }

    List<List<Integer>> helper(Integer[] keys, TreeMap<Integer, Integer> numCount, int pos) {
        if (pos == keys.length) {
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> currSub = new ArrayList<>();
            currSub.add(list);
            return currSub;
        }
        int curr_num = keys[pos];
        int count = numCount.get(curr_num);
        List<List<Integer>> prevSub = helper(keys, numCount, pos+1);
        List<List<Integer>> currSub = new ArrayList<>();
        currSub.addAll(prevSub);
        for (List<Integer> list  : prevSub) {
            for (int i=1; i<=count; i++) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);

                for (int j=1; j<=i; j++) {
                    newList.add(curr_num);
                }
                currSub.add(newList);
            }
        }
        return currSub;
    }
}