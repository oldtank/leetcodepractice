package xin.leetcode.sqrtx_69;

/**
 * Created by Xin on 10/6/2016.
 */
public class Solution {
    public int mySqrt(int x) {
        if (x==0) {
            return 0;
        }
        int left = 1, right = x;
        while (left <= right) {
            double mid = (left+right) / 2;
            if (mid*mid == x) {
                return (int)mid;
            } else if (mid*mid > x) {
                right = (left + right) / 2 -1;
            } else {
                left = (left + right) / 2 + 1;
            }
        }
        return right;
    }
}