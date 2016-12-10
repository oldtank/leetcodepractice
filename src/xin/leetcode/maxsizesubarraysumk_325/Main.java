package xin.leetcode.maxsizesubarraysumk_325;

/**
 * Created by Xin on 10/4/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(new Solution().maxSubArrayLen(nums, k));
    }
}
