package xin.interview.parenthesiswithsmiley;

/**
 * Created by Xin on 11/26/2016.
 */
public class Solution {
    public boolean verify(String s) {
        int maxOpen=0, minOpen=0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                maxOpen++;
                if (i==0 || s.charAt(i-1) != ':') {
                    minOpen++;
                }
            } else if (s.charAt(i) == ')') {
                minOpen = Math.max(0, minOpen-1);
                if (i==0 || s.charAt(i-1) != ':') {
                    maxOpen--;
                }
                if (maxOpen < 0) {
                    return false;
                }
            } else {
                continue;
            }
        }

        if (maxOpen >=0 && minOpen == 0) {
            return true;
        } else {
            return false;
        }
    }
}
