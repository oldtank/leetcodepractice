package xin.leetcode.longestsubstring_3;

import java.util.HashMap;

/**
 * Created by Xin on 8/28/2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() ==0) {
            return 0;
        }
        int max[] = new int[s.length()];
        max[s.length()-1] = 1;
        for (int i=s.length()-2; i>=0; i--) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                max[i] = 1;
            } else {
                int j=1;
                for (;j<=max[i+1];j++) {
                    if (s.charAt(i) == s.charAt(i + j)) {
                        break;
                    }
                }
                max[i] = j;
            }
        }
        int result = 0;
        for (int i : max) {
            if (result < i) {
                result =i;
            }
        }
        return result;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int n=s.length(), result=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0, j=0; j<n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j))+1, i);
            }
            result = Math.max(j-i+1, result);
            map.put(s.charAt(j), j);
        }
        return result;
    }

    public static void helper(String s, int curr, int max[]) {


        if (s.length() == 0){
            max[curr] =0;
        }
        if (s.length() ==1) {
            max[curr]=1;
        }

        if (s.charAt(0) == s.charAt(1)) {
            max[curr]=1;
        }
        helper(s.substring(1), curr+1, max);
        int i=1;
        for (; i<=max[curr+1]; i++) {
            if (s.charAt(i) == s.charAt(0)) {
                break;
            }
        }
        max[curr]=i;
    }
}
