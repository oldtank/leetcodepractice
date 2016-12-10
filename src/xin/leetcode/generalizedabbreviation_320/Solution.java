package xin.leetcode.generalizedabbreviation_320;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/2/2016.
 */
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>();
        if (word.length() == 0) {
            return list;
        }
        backtrack(list, "", 0, 0, word);
        return list;
    }

    public void backtrack(List<String> list, String abbr, int pos, int count, String word) {
        if (pos == word.length()) {
            if (count > 0) {
                abbr += count;
            }
            list.add(abbr);
        } else {
            backtrack(list, abbr + (count > 0 ? count : "") + word.charAt(pos), pos+1, 0, word);
            backtrack(list, abbr, pos+1, count+1, word);
        }
    }

    public List<String> generateAbbreviations2(String word) {
        List<String> list = new ArrayList<>();
        if (word.length() == 0) {
            list.add("");
            return list;
        }

        for (int i=0; i<Math.pow(2, word.length()); i++) {
            String binary = Integer.toBinaryString(i);
            if (binary.length() < word.length()) {
                int n = word.length() - binary.length();
                for (int x=0; x<n; x++) {
                    binary = "0" + binary;
                }
            }
            StringBuilder sb = new StringBuilder();
            int curr_pos =0;
            while(curr_pos < binary.length()) {
                int next_one_pos = binary.indexOf("1", curr_pos);
                if (next_one_pos >= 0) {
                    if (next_one_pos - curr_pos >= 1) {
                        sb.append(next_one_pos - curr_pos);
                    }
                    sb.append(word.charAt(next_one_pos));
                } else {
                    sb.append(word.length()-curr_pos);
                    break;
                }
                curr_pos = next_one_pos + 1;
            }
            list.add(sb.toString());
        }
        return list;
    }

    public List<String> generateAbbreviations1(String word) {
        List<String> list = new ArrayList<>();
        if (word.length() == 0) {
            list.add("");
            return list;
        }
        for (int i=0; i<Math.pow(2, word.length()); i++) {
            String abb = "";
            int zero_count = 0;
            for (int j=0; j<word.length(); j++) {
                if ((i & (1 << j)) ==0) {
                    zero_count++;
                } else {
                    if (zero_count > 0) {
                        abb = abb + zero_count;
                        abb = abb + word.charAt(j);
                        zero_count =0;
                    } else {
                        abb = abb + word.charAt(j);
                    }
                }
            }
            if (zero_count > 0) {
                abb =abb + zero_count;
            }
            list.add(abb);
        }
        return list;
    }
}