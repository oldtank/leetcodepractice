package xin.leetcode.largestdivisiblesubset_368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xin on 9/5/2016.
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        lists.add(list);
        int max_at = 0;

        for (int i=1; i<nums.length; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[i]);
            for (int j=i-1; j>=0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (lists.get(j).size() +1 > l.size()) {
                        l.clear();
                        l.addAll(lists.get(j));
                        l.add(nums[i]);
                    }
                }
            }
            if (l.size() > lists.get(max_at).size()) {
                max_at = i;
            }
            lists.add(l);
        }

        return lists.get(max_at);
    }
}