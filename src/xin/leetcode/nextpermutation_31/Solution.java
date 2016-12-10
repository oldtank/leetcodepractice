package xin.leetcode.nextpermutation_31;

/**
 * Created by Xin on 9/2/2016.
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int N = nums.length;
        int i=N-2;
        while (i >=0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i<0) {
            reverse(nums, 0, N-1);
            return;
        }
        int j=N-1;
        while (j>=i+1 && nums[j] <= nums[i]) {
            j--;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        reverse(nums, i+1, N-1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;

            left++;
            right--;
        }
    }
}