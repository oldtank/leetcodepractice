package xin.leetcode.increasingtripletsequence_334;

/**
 * Created by Xin on 10/4/2016.
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int first=Integer.MAX_VALUE, second=Integer.MAX_VALUE;
        int i=1;
        for (; i<nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                first = nums[i-1];
                second = nums[i];
                break;
            }
        }
        boolean replaceFirstFound=false;
        int new_first=0;
        for (int j=i+1; j<nums.length; j++) {
            if (nums[j] > second) {
                return true;
            } else if (nums[j] > first) {
                second = nums[j];
            } else {
                if (!replaceFirstFound) {
                    new_first = nums[j];
                    replaceFirstFound = true;
                } else {
                    if (nums[j] > new_first) {
                        first = new_first;
                        second = nums[j];
                        replaceFirstFound = false;
                    } else {
                        new_first = nums[j];
                    }
                }
            }
        }
        return false;
    }
}