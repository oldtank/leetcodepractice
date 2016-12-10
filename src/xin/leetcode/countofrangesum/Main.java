package xin.leetcode.countofrangesum;

/**
 * Created by Xin on 9/18/2016.
 */
public class Main {
    public static void main(String[] args) {
        int nums[] = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        System.out.println(new Solution().countRangeSum(nums, lower, upper));
    }
}
