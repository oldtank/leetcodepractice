package xin.leetcode.encodeanddecodestrings_271;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/1/2016.
 */
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s.length()).append("-").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() == 0) {
            return list;
        }
        int i=0;
        while (i < s.length()) {
            int separator_index = s.indexOf('-', i);
            int length = Integer.parseInt(s.substring(i, separator_index));
            list.add(s.substring(separator_index+1, separator_index+1+length));
            i = separator_index+1+length;
        }
        return list;
    }
}