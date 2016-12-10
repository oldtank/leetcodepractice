package xin.leetcode.palindromepationing_131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        if (s.length() == 0) {
            List<List<String>> lists = new ArrayList<>();
            return lists;
        }

        List<List<String>> lists = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            String prefix = s.substring(0, i+1);
            if (isPalindrome(prefix)) {
                List<List<String>> sublists = partition(s.substring(i+1));
                if (sublists.size() == 0) {
                    List<String> list = new LinkedList<>();
                    list.add(prefix);
                    lists.add(list);
                } else {
                    for (List<String> sublist : sublists) {
                        LinkedList<String> list = new LinkedList<>(sublist);
                        list.addFirst(prefix);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        for (int left = 0, right=s.length()-1; left<right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }

}
