package xin.leetcode.slidingwindowmaximum_239;

/**
 * Created by Xin on 9/9/2016.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {1,3,-1,-3,5,3,6,7};
        solution.maxSlidingWindow(nums, 3);
    }
}
