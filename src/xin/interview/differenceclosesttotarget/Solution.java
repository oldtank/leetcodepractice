package xin.interview.differenceclosesttotarget;

import java.util.Arrays;

/**
 * given an array and a target, find two numbers in the array such that the difference
 * between the two numbers are closest to the target.
 */
public class Solution {
    public int findClosestDifference(int[] nums, int target) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        int diff = nums[j] - nums[i];
        int closest = diff;

        while (j < nums.length) {
            System.out.println("checking between i " + nums[i] + " and j " + nums[j]);
            diff = nums[j] - nums[i];
            if (diff == target) {
                System.out.println("found diff");
                return diff;
            }
            closest = Math.abs(closest-target) > Math.abs(diff - target) ? diff : closest;
            if (diff < target) {
                j++;
            } else {
                if (i < j-1) {
                    i++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return closest;
    }
}
