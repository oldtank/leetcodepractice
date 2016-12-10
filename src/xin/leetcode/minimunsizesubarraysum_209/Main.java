package xin.leetcode.minimunsizesubarraysum_209;

/**
 * Created by Xin on 10/28/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        System.out.println(new Solution().minSubArrayLen(s, nums));
    }
}
