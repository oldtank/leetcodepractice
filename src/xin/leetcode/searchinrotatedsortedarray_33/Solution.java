package xin.leetcode.searchinrotatedsortedarray_33;

/**
 * Created by Xin on 10/6/2016.
 */
public class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length-1, target);
    }

    int helper(int[] nums, int start, int end, int target) {
        System.out.println("checking " + start + " to " +end);
        if (start > end) {
            return -1;
        }

        int mid = (start+end)/2;
        if (nums[mid] == target) {
            return mid;
        }

        // right side is increasing
        if (nums[mid] < nums[end] && target < nums[mid]) {
            return helper(nums, start, mid-1, target);
        } else if (nums[mid] > nums[0] && target > nums[mid]) {
            return helper(nums, mid+1, end, target);
        } else {
            int tmp = helper(nums, start, mid-1, target);
            if (tmp < 0) {
                return helper(nums, mid+1, end, target);
            } else {
                return tmp;
            }
        }
    }
}