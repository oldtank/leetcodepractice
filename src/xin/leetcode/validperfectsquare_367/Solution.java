package xin.leetcode.validperfectsquare_367;

/**
 * Created by Xin on 11/20/2016.
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num==0 || num == 1) {
            return true;
        }

        int left = 1, right = num/2;
        while (left <= right) {
            int mid = (left+right)/2;
            System.out.println("checking mid: " + mid + " " + left + " " + right);
            if ((long)mid*mid == num) {
                return true;
            } else if ((long)mid*mid > num) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }
}