package xin.leetcode.movezeros_283;

/**
 * Created by Xin on 11/16/2016.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int pos_to_fill = 0;
        int curr = 0;
        while (curr < nums.length) {
            if (nums[curr] == 0) {
                curr++;
            } else {
                nums[pos_to_fill] = nums[curr];
                pos_to_fill++;
                curr++;
            }
        }
        curr = pos_to_fill;
        while (curr < nums.length) {
            nums[curr] = 0;
            curr++;
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        for (int curr= 0, lastNonZero=-1; curr < nums.length; curr++) {
            if (nums[curr] != 0) {
                swap(nums, lastNonZero+1, curr);
                lastNonZero++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i==j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}