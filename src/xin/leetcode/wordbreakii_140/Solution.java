package xin.leetcode.wordbreakii_140;

import java.util.*;

/**
 * Created by Xin on 9/16/2016.
 */
public class Solution {
    public List<String> wordBreak1(String s, Set<String> wordDict) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }

        Map<Integer, List<String>> dp = new HashMap<>();
        dp.put(s.length(), new ArrayList<>());
        for (int start = s.length()-1; start >=0; start--) {
            helper(s, start, wordDict, dp);
        }
        return dp.get(0);
    }

    public void helper(String s, int start, Set<String> dict, Map<Integer, List<String>> dp) {
//        System.out.println("========= doing start = " + start + "==========");
        List<String> list = new ArrayList<>();
        for (int firstWord = start+1; firstWord <= s.length(); firstWord++) {
            String firstWord_s = s.substring(start, firstWord);
//            System.out.println("firstword: "+firstWord_s);
            if (dict.contains(firstWord_s)) {
                if (dp.get(firstWord).isEmpty()) {
                    if (firstWord == s.length()) {
                        list.add(firstWord_s);
                    }
                } else {
                    for (String sub : dp.get(firstWord)) {
                        list.add(firstWord_s + " " +sub);
                    }
                }
            }
        }

//        System.out.println("adding start " + start + ":");
//        System.out.println("llist: "+list);
        dp.put(start, list);
    }
}