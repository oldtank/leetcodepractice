package xin.leetcode.sortcolors_75;

/**
 * Created by Xin on 10/6/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1,2};
        Solution s = new Solution();
        s.sortColors(nums);
        for (int i : nums) {
            System.out.print(i+ " ");
        }
    }
}
