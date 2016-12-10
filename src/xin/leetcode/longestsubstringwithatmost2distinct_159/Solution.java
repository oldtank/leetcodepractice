package xin.leetcode.longestsubstringwithatmost2distinct_159;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xin on 10/7/2016.
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) {
            return s.length();
        }
        Map<Character, Integer> charCount = new HashMap<>();
        int length=1, start=0, max = 1;
        charCount.put(s.charAt(start), 1);
        int uniq = 1;
        int end = 1;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (charCount.containsKey(c) && charCount.get(c) > 0) {
                length++;
                System.out.println(s.substring(start, end+1)+ ": "+ length);
                max = Math.max(length, max);
                charCount.put(c, charCount.get(c)+1);
            } else {
                if (uniq < 2) {
                    uniq++;
                    charCount.put(c, 1);
                    length++;
                    System.out.println(s.substring(start, end+1)+ ": "+ length);
                    max = Math.max(length, max);
                } else {
                    while (start < end) {
                        char cStart = s.charAt(start);
                        int ct = charCount.get(cStart);
                        if (ct == 1) {
                            charCount.put(cStart, 0);
                            System.out.println("removing " + s.charAt(start));
                            start++;
                            uniq--;
                            break;
                        } else {
                            charCount.put(cStart, ct-1);
                            start++;
                        }
                    }
                    uniq++;
                    charCount.put(c, 1);
                    length = end - start + 1;
                    System.out.println(s.substring(start, end+1)+ ": "+ length);
                    max = Math.max(length, max);
                }
            }
            end++;
        }
        return max;
    }
}