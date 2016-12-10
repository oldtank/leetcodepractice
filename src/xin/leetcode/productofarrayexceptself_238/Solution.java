package xin.leetcode.productofarrayexceptself_238;

/**
 * Created by Xin on 10/3/2016.
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[nums.length-1] = 1;
        for (int i=1; i<nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
            right[nums.length-1-i] = right[nums.length-i] * nums[nums.length-i];
        }

        int[] result = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}