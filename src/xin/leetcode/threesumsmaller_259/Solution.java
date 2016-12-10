package xin.leetcode.threesumsmaller_259;

import java.util.Arrays;
import java.util.jar.Pack200;

/**
 * Created by Xin on 8/31/2016.
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count =0;
        for (int i=0; i<=nums.length-3;i++) {
            for (int j=i+1; j<=nums.length-2; j++) {
                int third = findFloor(nums, j+1, nums.length-1, target-nums[i]-nums[j]);
                if (third > 0) {
                    count += third-(j+1)+1;
                }
            }
        }
        return count;
    }

    public int findFloor(int[] nums, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            if (nums[start] < key) {
                return start;
            } else {
                return -1;
            }
        }
        int mid = (start+end)/2;
        if (nums[mid] == key) {
            return findFloor(nums, start, mid-1, key);
        } else if (nums[mid] < key) {
            if (nums[mid+1] >= key) {
                return mid;
            } else {
                return findFloor(nums, mid+1, end, key);
            }
        } else {
            return findFloor(nums, start, mid-1, key);
        }
    }
}