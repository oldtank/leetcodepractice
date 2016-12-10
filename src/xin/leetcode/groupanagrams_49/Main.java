package xin.leetcode.groupanagrams_49;

import java.util.*;

/**
 * Created by Xin on 8/26/2016.
 */
public class Main {
    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams2(strs));
    }

    public static String encode(String s) {
        int chars[] = new int[26];
        for (int i=0; i<s.length(); i++) {
            chars[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<chars.length; i++) {
            for (int j=0; j<chars[i]; j++) {
                sb.append((char)'a'+i).append("+");
            }
        }
        return sb.toString();
//        char s_char[] = s.toCharArray();
//        Arrays.sort(s_char);
//        return new String(s_char);
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> codeToList = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            String code = encode(strs[i]);
            codeToList.putIfAbsent(code, new ArrayList<>());
            codeToList.get(code).add(strs[i]);
        }

        List<List<String>> lists = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : codeToList.entrySet()) {
            lists.add(entry.getValue());
        }
        return lists;
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        for (int i=0; i<strs.length; i++) {
            //compare current string with discovered anagram lists
            int j=0;
            for (; j<lists.size(); j++) {
                if (isAnagram(strs[i], lists.get(j).get(0))) {
                    lists.get(j).add(strs[i]);
                    break;
                }
            }
            if (j==lists.size()) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                lists.add(list);
            }
        }
        return lists;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        int taken[] = new int[strs.length];
        for (int i=0; i<strs.length; i++) {
            if (taken[i] == 1) {
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            taken[i] = 1;
            for (int j=i+1; j<strs.length; j++) {
                if (taken[j] == 1) {
                    continue;
                }
                if (isAnagram(strs[i], strs[j])) {
                    list.add(strs[j]);
                    taken[j] = 1;
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }
        int charCounts[] = new int[26];
        for (int i=0; i<s.length(); i++) {
            charCounts[s.charAt(i)-'a']++;
        }
        for (int i=0; i<t.length(); i++) {
            if (charCounts[t.charAt(i)-'a'] ==0) {
                return false;
            }
            charCounts[t.charAt(i)-'a']--;
        }
        return true;
    }
}
