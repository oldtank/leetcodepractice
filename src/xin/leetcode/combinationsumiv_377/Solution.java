package xin.leetcode.combinationsumiv_377;

import java.util.Arrays;

/**
 * Created by Xin on 9/6/2016.
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums==null || nums.length ==0) {
            return 0;
        }
        if (target==0) {
            return 1;
        }
        if (target == nums[0]) {
            return 1;
        }
        if (target < nums[0]) {
            return 0;
        }
        int counts[] = new int[target+1];
        for (int i=0; i<counts.length; i++) {
            counts[i] = -1;
        }
        counts[0] = 1;
        for (int i=1; i<nums[0]; i++) {
            counts[i]=0;
        }
        counts[nums[0]] =1;
//        combinationSum4Helper(nums, target, counts);
        for (int t = nums[0]+1; t<=target; t++) {
            int tmp = 0;
            for (int i=0; i<nums.length; i++) {
                if (nums[i] > t) {
                    break;
                }
                tmp+=counts[t-nums[i]];
            }
            counts[t] = tmp;
        }
        return counts[target];
    }

    public int combinationSum4Helper(int[] nums, int target, int[] counts) {
        if (counts[target] != -1) {
            return counts[target];
        }

        int count=0;
        for (int firstIndex = 0; firstIndex<nums.length; firstIndex++) {
            if (nums[firstIndex] > target) {
                break;
            }
            count += combinationSum4(nums, target - nums[firstIndex]);
//            System.out.println("orig target: " + target +", firstIndex: "+firstIndex+ ", count: " +count);
        }
        counts[target] = count;
        return count;
    }
}