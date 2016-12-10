package xin.leetcode.minimumwindowsubstring_76;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Xin on 10/6/2016.
 */
public class Solution {
    class Duplet {
        char val;
        int pos;
        public Duplet(char v, int p) {
            val =v;
            pos = p;
        }
    }

    public String minWindow1(String s, String t) {
        if (t.length() == 0 ) {
            return "";
        }
        int[] counts = new int[26];
        for (int i=0; i<t.length(); i++) {
            counts[t.charAt(i) - 'A'] ++;
        }

        String result = "";
        int found = 0;
        int j=0;
        for (int i=0; i<s.length(); i++) {
            if (counts[s.charAt(i) - 'A'] > 0) {
                found++;
            }
            counts[s.charAt(i) - 'A']--;
            while (j<i) {
                if (counts[s.charAt(j) - 'A'] <0) {
                    counts[s.charAt(j) - 'A'] ++;
                    j++;
                } else {
                    break;
                }
            }
            if (found == t.length()) {
                String window = s.substring(j, i+1);
                System.out.println("window; " + window);
                if (result.equals("") || result.length() > window.length()) {
                    result = window;
                }
            }
        }
        return result;

    }

    public String minWindow(String s, String t) {
        PriorityQueue<Duplet> pq = new PriorityQueue<>((a, b) -> (a.pos - b.pos));
        Map<Character, Integer> tCounts = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            tCounts.putIfAbsent(c, 0);
            tCounts.put(c, tCounts.get(c) + 1);
        }
        String minString = "";
        int tCharEncountered=0;
        Map<Character, Integer> counts = new HashMap<>();
        for (int right = 0; right<s.length(); right++) {
            char c = s.charAt(right);
            if (tCounts.containsKey(c)) {
                if (!counts.containsKey(c)) {
                    tCharEncountered++;
                    counts.put(c, 1);
                } else {
                    if (counts.get(c) < tCounts.get(c)) {
                        tCharEncountered++;
                    }
                    counts.put(c, counts.get(c) + 1);
                }
                pq.offer(new Duplet(c, right));
            }
            while(!pq.isEmpty() && counts.get(pq.peek().val) > tCounts.get(pq.peek().val)) {
                Duplet d = pq.poll();
                counts.put(d.val, counts.get(d.val)-1);
            }
            if (tCharEncountered == t.length()) {
                int left = pq.peek().pos;
                System.out.println("left: " + left + ", right: " + right);
                System.out.println("window: " + s.substring(left, right + 1) + "\n");
                if (minString.length() == 0 || right - left < minString.length()) {
                    minString = s.substring(left, right + 1);
                }
            }
        }
        return minString;
    }
}