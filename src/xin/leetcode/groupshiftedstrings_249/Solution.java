package xin.leetcode.groupshiftedstrings_249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 9/25/2016.
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> list = new ArrayList<>();
        if (strings.length == 0) {
            return list;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i<strings.length; i++) {
            String code = getCode(strings[i]);
            System.out.println("string: " + strings[i] + "; code: " + code);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(strings[i]);
        }
        for (String code : map.keySet()) {
            list.add(map.get(code));
        }
        return list;
    }

    public String getCode(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() == 0) {
            return "-1";
        }
        if (s.length() == 1) {
            return "";
        }
        for (int i=1; i<s.length(); i++) {
            sb.append((s.charAt(i) - s.charAt(i-1) + 26) % 26);
        }
        return sb.toString();
    }
}