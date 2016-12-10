package xin.leetcode.longestconsecutiveseq_128;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xin on 9/8/2016.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        Map<Integer, Integer> edgeLength = new HashMap<>();
        int res = 0;
        for (int i=0 ; i < nums.length; i++) {
            if (!edgeLength.containsKey(nums[i])) {
                int left = edgeLength.containsKey(nums[i]-1) ? edgeLength.get(nums[i]-1) : 0;
                int right = edgeLength.containsKey(nums[i]+1) ? edgeLength.get(nums[i]+1) : 0;

                int sum = left + right + 1;
                edgeLength.put(nums[i], sum);
                res = Math.max(res, sum);

                edgeLength.put(nums[i]-left, sum);
                edgeLength.put(nums[i]+right, sum);

            } else {
                continue;
            }
        }
        return res;
    }
}