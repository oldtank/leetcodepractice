package xin.leetcode.longestpalindrome_409;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xin on 10/3/2016.
 */
public class Solution {
    public int longestPalindrome(String s) {
        if (s.length() ==0 || s.length() == 1) {
            return s.length();
        }
        boolean oddEncountered=false;
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (charCount.containsKey(s.charAt(i))) {
                charCount.put(s.charAt(i), charCount.get(s.charAt(i)) + 1);
            } else {
                charCount.put(s.charAt(i), 1);
            }
        }

        int length = 0;
        for(Character key : charCount.keySet()) {
            int count = charCount.get(key);
            if (count % 2 ==0){
                length += count;
            } else {
                if (!oddEncountered) {
                    length += count;
                    oddEncountered = true;
                } else {
                    length += (count - 1);
                }
            }
        }
        return length;
    }
}