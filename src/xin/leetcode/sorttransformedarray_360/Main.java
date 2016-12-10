package xin.leetcode.sorttransformedarray_360;

/**
 * Created by Xin on 10/2/2016.
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-4, -2, 2, 4};
        int a=-1, b=3, c=5;
        int[] result = s.sortTransformedArray(nums, a, b, c);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
