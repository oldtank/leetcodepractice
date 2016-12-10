package xin.leetcode.strstr_28;

/**
 * Created by Xin on 11/19/2016.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i=0; i<=haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            boolean found = true;
            for (int j=0, k=i; j<needle.length(); j++, k++) {
                if (haystack.charAt(k) != needle.charAt(j)){
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}