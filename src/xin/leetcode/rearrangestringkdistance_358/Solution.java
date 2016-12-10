package xin.leetcode.rearrangestringkdistance_358;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Xin on 9/20/2016.
 */
public class Solution {
    public String rearrangeString(String str, int k) {
        if (str.length() <=1) {
            return str;
        }
        int counts[] = new int[26];
        for (int i=0; i<str.length(); i++) {
            counts[str.charAt(i)-'a']++;
        }

        PriorityQueue<LetterCount> queue = new PriorityQueue<>((a, b) -> b.count-a.count);
        for (int i=0; i<26; i++) {
            if (counts[i] > 0) {
                queue.offer(new LetterCount((char)('a'+i), counts[i]));
            }
        }

        LetterCount mostFrequent = queue.poll();
        String segments[] = new String[mostFrequent.count];
        for (int i=0; i<segments.length; i++) {
            segments[i] = "" + mostFrequent.letter;
        }

        int currSegment = 0;
        while (!queue.isEmpty()) {
            LetterCount currLetterCount = queue.poll();
            if (currLetterCount.count == mostFrequent.count) {
                for (int i=0; i<currLetterCount.count; i++) {
                    segments[currSegment] += currLetterCount.letter;
                    currSegment = (currSegment+1)%segments.length;
                }
            } else {
                for (int i = 0; i < currLetterCount.count; i++) {
                    segments[currSegment] += currLetterCount.letter;
                    currSegment = (currSegment + 1) % (segments.length-1);
                }
            }
        }
        if (segments[segments.length-2].length()>=k) {
            StringBuilder sb =new StringBuilder();
            for(String segment : segments) {
                sb.append(segment);
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    class LetterCount {
        char letter;
        int count;

        public LetterCount(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }
}