package xin.leetcode.palindromepationing_131;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 11/25/2016.
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        boolean[][] isPalindrom = new boolean[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) {
            isPalindrom[i][i] = true;
        }
        for (int i=0; i<s.length()-1; i++) {
            isPalindrom[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }
        for (int length=2; length<=s.length()-1; length++) {
            for (int i=0; i+length<s.length(); i++) {
                isPalindrom[i][i+length] = isPalindrom[i+1][i+length-1] && (s.charAt(i) == s.charAt(i+length));
            }
        }

        //dp.get(i): list of partitions using s ending at index i
        List<List<List<String>>> dp = new ArrayList<>();
        List<String> initial = new ArrayList<>();
        initial.add(s.charAt(0) + "");
        List<List<String>> initialList = new ArrayList<>();
        initialList.add(initial);
        dp.add(initialList);

        for (int i=1; i<s.length(); i++) {
            List<List<String>> currList = new ArrayList<>();
            if (isPalindrom[0][i]) {
                List<String> l = new ArrayList<>();
                l.add(s.substring(0, i+1));
                currList.add(l);
            }

            for (int j=1; j<=i; j++) {
                if (isPalindrom[j][i]) {
                    List<List<String>> prevList = dp.get(j-1);
                    for (int k=0; k<prevList.size(); k++) {
                        List<String> l = new ArrayList<>(prevList.get(k));
                        l.add(s.substring(j, i+1));
                        currList.add(l);
                    }
                }
            }
            dp.add(currList);
        }
        return dp.get(s.length()-1);
    }

//    void helper(List<List<String>> result, )
}