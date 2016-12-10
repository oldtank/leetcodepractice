package xin.leetcode.maxsizesubarraysumk_325;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 10/4/2016.
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> sumToPosMap = new HashMap<>();
        sumToPosMap.put(0, -1);
        int sum=0, length=0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (sumToPosMap.containsKey(sum - k)) {
                length = Math.max(length, i-sumToPosMap.get(sum - k));
            }
            if(!sumToPosMap.containsKey(sum)) {
                sumToPosMap.put(sum, i);
            }
        }
        return length;
    }

    public int maxSubArrayLen1(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> prev_sum_length_map = new HashMap<>();
        Map<Integer, Integer> curr_sum_length_map = new HashMap<>();
        int length = 0;

        if (nums[0] == k) {
            length = 1;
        }
        prev_sum_length_map.put(nums[0], 1);

        for (int i=1; i<nums.length; i++) {
            curr_sum_length_map = new HashMap<>();
            curr_sum_length_map.put(nums[i], 1);
            if (length == 0 && nums[i] == k) {
                length = 1;
            }
            for (int result : prev_sum_length_map.keySet()) {
                int new_sum = result + nums[i];
                int new_length = prev_sum_length_map.get(result) + 1;
                if (new_sum == k) {
                    length = Math.max(length, new_length);
                }
                curr_sum_length_map.put(new_sum, new_length);
            }
            prev_sum_length_map = curr_sum_length_map;
        }
        return length;
    }
}