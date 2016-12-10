package xin.leetcode.patchingarray_330;

/**
 * Created by Xin on 9/23/2016.
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        int added=0;
        int currmax = 1;
        int i=0;
        while (currmax <= n) {
            if (i == nums.length) {
                added++;
                currmax += currmax;
            } else {
                if (nums[i] <= currmax) {
                    currmax += nums[i];
                    i++;
                } else {
                    added++;
                    currmax += currmax;
                }
            }
        }
        return added;
    }
}