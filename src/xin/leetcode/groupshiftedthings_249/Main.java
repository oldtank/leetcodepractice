package xin.leetcode.groupshiftedthings_249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

 For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 A solution is:

 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]

 https://leetcode.com/problems/group-shifted-strings/
 */
public class Main {

    public static void main(String[] args) {
        String strings[] = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> lists = groupStrings(strings);
        for (List<String> list : lists) {
            list.forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }

    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String code = encodeString(s);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(s);
        }
        List<List<String>> lists = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            lists.add(entry.getValue());
        }
        return lists;
    }

    public static String encodeString(String s) {
        if (s.length() == 0) {
            return s;
        }
//        char min=s.charAt(0);
//        for (int i=1; i<s.length();i++) {
//            if (min > s.charAt(i)) {
//                min = s.charAt(i);
//            }
//        }
        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<s.length(); i++) {
            int offset = sb.charAt(i)-s.charAt(0);
            if (offset < 0) {
                offset += 26;
            }
            sb.setCharAt(i, (char) ('a' + offset));
        }
        return sb.toString();
    }
}
