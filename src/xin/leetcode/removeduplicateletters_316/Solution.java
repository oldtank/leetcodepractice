package xin.leetcode.removeduplicateletters_316;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Xin on 9/20/2016.
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        int counts[] = new int[26] ;
        for (int i=0; i<s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        ArrayDeque<Character> queue = new ArrayDeque<>();
        boolean visited[] = new boolean[26];
        for (int i=0; i<s.length(); i++) {
            counts[s.charAt(i)-'a']--;
            if (visited[s.charAt(i)-'a']) {
                continue;
            }
            while (!queue.isEmpty() && s.charAt(i) < queue.getLast() && counts[queue.getLast()-'a'] > 0) {
                char top = queue.removeLast();
                visited[top-'a'] = false;
            }
            queue.addLast(s.charAt(i));
            visited[s.charAt(i)-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.removeFirst());
        }
        return sb.toString();
    }
}