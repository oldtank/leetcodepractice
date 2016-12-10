package xin.leetcode.shortestpalindrome_214;

/**
 * Created by Xin on 9/18/2016.
 */
public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int max_length = 0;
        for (int i=0; i<s.length();) {
            int left = i;
            int right = i;
            while (right < s.length()-1 && s.charAt(right) == s.charAt(right+1)) {
                right++;
            }
            i = right+1;
            while (left > 0 && right < s.length()-1) {
                if (s.charAt(left-1) == s.charAt(right+1)) {
                    left --;
                    right++;
                } else {
                    break;
                }
            }
            if (left == 0 && max_length < right + 1) {
                max_length = right+1;
            }
        }
        String prefix = new StringBuilder(s.substring(max_length)).reverse().toString();
        return prefix+s;
    }
}
