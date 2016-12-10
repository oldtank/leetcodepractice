package xin.leetcode.minimumuniquewordabbr_411;

import java.util.*;

/**
 * Created by Xin on 10/3/2016.
 */
public class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        if (dictionary.length == 0 ) {
            return Integer.toString(target.length());
        }
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        generate(map, target, 0, 0, new StringBuilder(), 0);
        for(int key : map.keySet()) {
            List<String> abbrs = map.get(key);
            for (String abbr : abbrs) {
                String[] abbr_tokens = abbr.split(",");
                int i=0;
                for (; i<dictionary.length; i++) {
                    if (match(abbr_tokens, dictionary[i])) {
//                        System.out.println(abbr + " not match with " + dictionary[i]);
                        break;
                    }
                }
                if (i == dictionary.length) {
                    StringBuilder sb = new StringBuilder();
                    for (String s : abbr_tokens) {
                        sb.append(s);
                    }
                    return sb.toString();
                }

            }
        }
        return "";
    }

    public void generate(Map<Integer, List<String>> map, String target, int pos, int count, StringBuilder sb, int wordCount) {
        int l = sb.length();
        if (pos == target.length()) {
            if (count > 0) {
                sb.append(Integer.toString(count));
                wordCount ++;
            }
            map.putIfAbsent(wordCount, new ArrayList<>());
//            System.out.println(abbr + " " + wordCount);
            map.get(wordCount).add(sb.toString());
            sb.setLength(l);
        } else {
            //abbreviate current char
            generate(map, target, pos+1, count+1, sb, wordCount);
            sb.setLength(l);
            //use current char
            if (count > 0) {
                generate(map, target, pos+1, 0, sb.append(count).append(",").append(target.charAt(pos)).append(","),
                        count > 0 ? wordCount+2 : wordCount+1);
            } else {
                generate(map, target, pos+1, 0, sb.append(target.charAt(pos)).append(","),
                        count > 0 ? wordCount+2 : wordCount+1);
            }
            sb.setLength(l);
        }
    }

    public boolean match(String[] abbr_tokens, String word) {
        int i_abbr = 0;
        int i_word = 0;
        while (i_abbr < abbr_tokens.length && i_word < word.length()) {
            if (abbr_tokens[i_abbr].charAt(0) >= '0' && abbr_tokens[i_abbr].charAt(0) <= '9') {
                int omitted =  Integer.parseInt(abbr_tokens[i_abbr]);
                if (word.length() - i_word < omitted) {
                    return false;
                } else {
                    i_abbr++;
                    i_word += omitted;
                }
            } else {
                if (word.charAt(i_word) == abbr_tokens[i_abbr].charAt(0)) {
                    i_word++;
                    i_abbr++;
                } else {
                    return false;
                }
            }
        }
        if (i_abbr == abbr_tokens.length && i_word == word.length()) {
            return true;
        } else {
            return false;
        }
    }
}