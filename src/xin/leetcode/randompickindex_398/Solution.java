package xin.leetcode.randompickindex_398;

import java.util.Random;

/**
 * Created by Xin on 10/4/2016.
 */
public class Solution {
    int[] nums;
    Random rand = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int randBase = 1;
        int currIndex = -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                if (rand.nextDouble() < 1D / randBase) {
                    currIndex = i;
                    randBase++;
                }
            }
        }
        return currIndex;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
