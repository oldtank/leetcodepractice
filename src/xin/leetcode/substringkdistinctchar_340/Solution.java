package xin.leetcode.substringkdistinctchar_340;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xin on 9/8/2016.
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k==0) {
            return 0;
        }
        if (s.length() <= k) {
            return s.length();
        }

        Map<Character, Integer> charPosMap = new HashMap<>();
        int max = 0;
        for (int start=0, end=0; end<s.length(); end++) {
            char curr = s.charAt(end);
            if (charPosMap.containsKey(curr)) {
                charPosMap.put(curr, end);
                max = Math.max(max, end-start+1);
            } else {
                if (charPosMap.keySet().size() < k) {
                    charPosMap.put(curr, end);
                    max = Math.max(max, end-start+1);
                } else {
                    int pos = Integer.MAX_VALUE;
                    char furtherChar='a';
                    for (Character tmp : charPosMap.keySet()) {
                        if (charPosMap.get(tmp) < pos) {
                            pos = charPosMap.get(tmp);
                            furtherChar = tmp;
                        }
                    }
                    start = charPosMap.get(furtherChar)+1;
                    charPosMap.remove(furtherChar);
                    charPosMap.put(curr, end);
                    max = Math.max(max, end-start+1);
                }
            }
        }
        return max;
    }
}