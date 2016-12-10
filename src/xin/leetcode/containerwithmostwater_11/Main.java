package xin.leetcode.containerwithmostwater_11;

/**
 * Created by Xin on 8/28/2016.
 */
public class Main {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length;
        int max = 0;
        while (left<right) {
            int area = Math.min(height[left], height[right]) * (right -left);
            max = Math.max(max, area);
            if (height[left] > height[right]) {
                right--;
            } else if (height[left] < height[right]) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }
}
