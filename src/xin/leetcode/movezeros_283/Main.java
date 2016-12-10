package xin.leetcode.movezeros_283;

/**
 * Created by Xin on 11/16/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes2(nums);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
