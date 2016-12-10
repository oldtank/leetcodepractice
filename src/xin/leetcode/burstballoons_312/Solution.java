package xin.leetcode.burstballoons_312;

/**
 * Created by Xin on 9/23/2016.
*/
public class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return clever(nums);
    }

    public int clever(int[] nums) {
        int n = nums.length + 2;
        int nums1[] = new int[n];
        nums1[0] = 1;
        nums1[nums1.length-1] = 1;
        for (int i=0; i<nums.length; i++) {
            nums1[i+1] = nums[i];
        }
        // dp[i][j]: value of bursting a balloon between i and j, EXCLUDING i or j
        int dp[][] = new int[nums.length+2][nums.length+2];
        for (int length=3; length<=n; length++) {
            for (int left = 0; left<=n-length; left ++) {
                int right = left + length - 1;
                for (int last = left + 1; last < right; last ++) {
                    dp[left][right] = Math.max(dp[left][right], nums1[last] * nums1[left] * nums1[right] + dp[left][last] + dp[last][right]);
                }
            }
        }
        return dp[0][n-1];

    }

    public int naive(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max=-1;
        for (int i=0; i<nums.length; i++) {
            int burst;
            if (i==0) {
                burst = nums[0] * nums[1];
            } else if (i==nums.length - 1) {
                burst = nums[i-1] * nums[i];
            } else {
                burst = nums[i-1] * nums[i] * nums[i+1];
            }
            int remaining[] = new int[nums.length-1];
            for (int j=0, x=0; x<nums.length;x++) {
                if (x == i) {
                    continue;
                } else {
                    remaining[j] = nums[x];
                    j++;
                }
            }
            max = Math.max(max, burst + naive(remaining));

        }
        return max;
    }
}
