package xin.leetcode.maximumsubarray_53;

/**
 * Created by Xin on 8/28/2016.
 */
public class Main {
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int sumEndingHere[] = new int[nums.length];
        sumEndingHere[0] = nums[0];
        int max = nums[0];
        for (int i=1; i<nums.length; i++) {
            sumEndingHere[i] = max(sumEndingHere[i-1]+nums[i], nums[i]);
            max = max(sumEndingHere[i], max);
        }
        return max;
    }

    public static int max(int a, int b) {
        return a>b ? a: b;
    }
}
