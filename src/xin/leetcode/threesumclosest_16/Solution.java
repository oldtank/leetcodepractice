package xin.leetcode.threesumclosest_16;

import java.util.Arrays;

/**
 * Created by Xin on 10/8/2016.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i=0; i<nums.length-2; i++) {
            sum = getCloser(sum,
                    nums[i] + twoSumClosest(nums, i+1, nums.length-1, target - nums[i]),
                    target);
        }
        return sum;

    }

    int twoSumClosest(int[] nums, int left, int right, int target) {
        int sum = nums[left]+nums[right];
        while (left < right) {
            int curr = nums[left] + nums[right];
            if (curr == target) {
                return target;
            } else {
                sum = getCloser(sum, curr, target);
                if (target > curr) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sum;
    }

    int getCloser(int i, int j, int target) {
        return Math.abs(i-target) > Math.abs(j-target) ? j : i;
    }
}