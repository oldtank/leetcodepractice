package xin.leetcode.lettercombinationofphonenumber_17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 11/20/2016.
 */
public class Solution {
    String[] mapping = {" ", null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        recursive(new StringBuilder(), digits, 0, result);
        return result;
    }

    void recursive(StringBuilder sb, String digits, int pos, List<String> result) {
        if (pos == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String mapped = mapping[digits.charAt(pos) - '0'];
        if (mapped == null) {
            recursive(sb, digits, pos+1, result);
        } else {
            for (int i=0; i< mapped.length(); i++) {
                sb.append(mapped.charAt(i));
                recursive(sb, digits, pos+1, result);
                sb.setLength(sb.length()-1);
            }
        }
    }
}