package xin.leetcode.substring2distinctchar_159;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

 For example, Given s = “eceba”,

 T is "ece" which its length is 3.
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length()<=2) {
            return s.length();
        }
        int max=0;
        Map<Character, Integer> charToIndexMap = new HashMap<>();
        for (int start=0, end=0; end < s.length(); end++) {
            if (charToIndexMap.containsKey(s.charAt(end))) {
                charToIndexMap.put(s.charAt(end), end);
                max = Math.max(max, end-start+1);
            }
            if (charToIndexMap.get(s.charAt(end)) == null) {
                if (charToIndexMap.keySet().size() <= 1) {
                    charToIndexMap.put(s.charAt(end), end);
                    max = Math.max(max, end-start+1);
                } else {
                    char furtherChar='a';
                    int pos = Integer.MAX_VALUE;
                    Set<Character> uniques = charToIndexMap.keySet();
                    for (Character cha : uniques) {
                        if (charToIndexMap.get(cha) < pos) {
                            pos = charToIndexMap.get(cha);
                            furtherChar = cha;
                        }
                    }
//                    System.out.println("remove char "+furtherChar+ " at pos "+charToIndexMap.get(furtherChar));
                    start = charToIndexMap.get(furtherChar)+1;
                    charToIndexMap.remove(furtherChar);
                    charToIndexMap.put(s.charAt(end), end);
                    max = Math.max(max, end-start+1);
                }
            }
        }
        return max;
    }
}