package xin.leetcode.validwordabbreviation_408;

/**
 * Created by Xin on 10/3/2016.
 */
public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i_word = 0;
        int i_abbr = 0;
        while (i_word < word.length() && i_abbr < abbr.length()) {
            if (abbr.charAt(i_abbr) >= 'a' && abbr.charAt(i_abbr) <= 'z') {
                if (word.charAt(i_word) == abbr.charAt(i_abbr)) {
                    i_word++;
                    i_abbr++;
                } else {
                    return false;
                }
            } else {
                if (abbr.charAt(i_abbr) == '0') {
                    return false;
                }
                int j=i_abbr+1;
                while (j<abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                    j++;
                }
                int num = Integer.parseInt(abbr.substring(i_abbr, j));
                if (word.length() - i_word < num) {
                    return false;
                }
                i_word += num;
                i_abbr = j;
            }
        }
        if (i_word == word.length() && i_abbr == abbr.length()) {
            return true;
        } else {
            return false;
        }
    }
}
