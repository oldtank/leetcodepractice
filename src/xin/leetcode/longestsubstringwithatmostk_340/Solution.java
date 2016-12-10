package xin.leetcode.longestsubstringwithatmostk_340;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Xin on 10/7/2016.
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        if (s.length() < k) {
            return s.length();
        }

        int uniq = 0;
        PriorityQueue<ValPos> pq = new PriorityQueue<>((a, b) -> (a.pos - b.pos));
        HashMap<Character, ValPos> map = new HashMap<>();
        int length=0,max=0;
        for (int i=0, j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c) && map.get(c) != null) {
                length = j-i+1;
                max = Math.max(length, max);
                ValPos vp = map.get(c);
                pq.remove(vp);
                vp = new ValPos(c, j);
                map.put(c, vp);
                pq.add(vp);
            } else {
                if (uniq < k) {
                    uniq++;
                    ValPos vp = new ValPos(c, j);
                    map.put(c, vp);
                    pq.add(vp);
                    length++;
                    max = Math.max(length, max);
                } else {
                    ValPos furthest = pq.poll();
                    map.put(furthest.val, null);
                    i = furthest.pos + 1;
                    length = j-i+1;
                    max = Math.max(length, max);
                    ValPos vp = new ValPos(c, j);
                    map.put(c, vp);
                    pq.add(vp);
                }
            }
        }
        return max;
    }

    class ValPos {
        char val;
        int pos;
        public ValPos(char v, int p) {
            val = v;
            pos = p;
        }
    }


    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
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
