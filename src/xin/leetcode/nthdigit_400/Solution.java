package xin.leetcode.nthdigit_400;

/**
 * Created by Xin on 9/22/2016.
 */
public class Solution {
    public int findNthDigit(int n) {
        if (n==0) {
            return 0;
        }
        int numberOfDigits = 1;
        long multiplier = 9;

        int tmp = n;
        while (tmp > numberOfDigits * multiplier) {
            tmp -= numberOfDigits * multiplier;
            numberOfDigits++;
            multiplier = multiplier*10;
        }
        System.out.println("number of digits:"+numberOfDigits);
        int fromNumber = (int) Math.pow (10, (numberOfDigits-1)) + (tmp-1)/numberOfDigits;
        return Integer.valueOf(fromNumber).toString().charAt((tmp-1)%numberOfDigits) - '0';
    }
}