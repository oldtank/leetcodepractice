package xin.leetcode.countandsay_38;

/**
 * Created by Xin on 11/20/2016.
 */
public class Solution {
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder("1");
        while (n > 1) {
            StringBuilder prev = new StringBuilder(result);
            result.setLength(0);
            int count = 1;
            for (int i=1; i<prev.length(); i++) {
                if (prev.charAt(i) == prev.charAt(i-1)) {
                    count++;
                } else {
                    result.append(count).append(prev.charAt(i-1));
                    count=1;
                }
            }
            result.append(count).append(prev.charAt(prev.length()-1));

            n--;
        }
        return result.toString();
    }
}