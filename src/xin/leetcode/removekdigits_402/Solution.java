package xin.leetcode.removekdigits_402;

/**
 * Created by Xin on 10/2/2016.
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        int countRemoved = 0;
        StringBuilder sb = new StringBuilder(num);
        for (int i=0; i<sb.length()-1;) {
            if (sb.charAt(i) > sb.charAt(i+1)) {
                sb.deleteCharAt(i);
                countRemoved ++;
                if (countRemoved == k) {
                    break;
                }
                if (i > 0) {
                    i-=1;
                }
            } else {
                i++;
            }
        }

        for (int i=0; i<k-countRemoved; i++) {
            sb.deleteCharAt(sb.length()-1);
        }

        int i=0;
        while (i <sb.length() && sb.charAt(i) == '0') {
            i++;
        }
//        System.out.println(i);
        if (i == sb.length()) {
            return "0";
        } else {
            return sb.substring(i);
        }
    }
}