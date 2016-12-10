package xin.leetcode.wordbreak_139;

import java.util.Set;

/**
 * Created by Xin on 8/31/2016.
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        boolean breakable[] = new boolean[s.length()+1];
        breakable[0] = true;
        for (int i=1; i<=s.length(); i++) {
            String sub = s.substring(0, i);
            for (int j=0; j<i; j++) {
                if (breakable[j] && wordDict.contains(sub.substring(j, i))) {
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length()];
    }

    public boolean helper(String s, int start, Set<String> wordDict) {
        if (start == s.length()) {
            return true;
        }
        if (wordDict.contains(s.substring(start))) {
            return true;
        }

        for (int i=start+1; i<=s.length(); i++) {
            if (wordDict.contains(s.substring(start, i)) && helper(s, i, wordDict)) {
                return true;
            }
        }
        return false;
    }
}