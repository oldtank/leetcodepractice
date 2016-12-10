package xin.leetcode.sortcolors_75;

/**
 * Created by Xin on 10/6/2016.
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int i=0, left = -1, right = nums.length;
        while (i < right) {
            if (nums[i] == 0) {
                swap(nums, left+1, i);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right-1);
                right--;
            } else {
                i++;
            }
        }
    }

    void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}