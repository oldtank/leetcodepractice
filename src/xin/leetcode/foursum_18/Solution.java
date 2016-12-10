package xin.leetcode.foursum_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xin on 11/27/2016.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<=nums.length-4;) {
            List<List<Integer>> sub = threeSum(nums, i+1, nums.length-1, target - nums[i]);
            for (int j=0; j<sub.size(); j++) {
                List<Integer> l = new ArrayList<>();
                l.addAll(sub.get(j));
                l.add(nums[i]);
                result.add(l);
            }
            i++;
            while (i<=nums.length-4 && nums[i] == nums[i-1]) {
                i++;
            }
        }
        return result;
    }

    List<List<Integer>> threeSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=start; i<=end-2;) {
            int left = i + 1, right = end;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == target) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    result.add(l);
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right = end;
                } else if (nums[i] + nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
            i++;
            while (i <= end - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return result;
    }
}