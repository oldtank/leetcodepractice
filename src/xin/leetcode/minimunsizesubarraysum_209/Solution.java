package xin.leetcode.minimunsizesubarraysum_209;

/**
 * Created by Xin on 10/28/2016.
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int i=0, j=0;
        int length = Integer.MAX_VALUE;
        while (j < nums.length) {
            if (nums[j] > s) {
                return 1;
            }
            sum += nums[j];
            if (sum >= s) {
                length = Math.min(length, j-i+1);
                System.out.println(String.format("length: %d, from %d to %d", j-i+1, i, j));

                while (i < j) {
                    sum -= nums[i];
                    i++;
                    if (sum >= s) {
                        System.out.println(String.format("length: %d, from %d to %d", j-i+1, i, j));
                        length = Math.min(length, j-i+1);
                    } else {
                        break;
                    }
                }
            }
            j++;
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}