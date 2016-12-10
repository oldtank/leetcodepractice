package xin.leetcode.minimumuniquewordabbr_411;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Xin on 10/3/2016.
 */
public class Solution1 {
    public String minAbbreviation(String target, String[] dictionary) {
        if (dictionary.length == 0) {
            return String.valueOf(target.length());
        }
        HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        search(map, target, new StringBuilder(), 0, 0, 0);
        int min = 1;
//        int max = target.length();
//        while (min <= max) {
//            int mid = min + (max - min) / 2;
//            if (ok(mid, map, dictionary)) {
//                max = mid - 1;
//            } else {
//                min = mid + 1;
//            }
//        }
        return map.get(min).get(0);
    }

    public void search(HashMap<Integer, List<String>> map, String target, StringBuilder now, int pos, int skip, int len) {
        int l = now.length();
        if (pos == target.length()) {
            if (skip > 0) {
                now.append(String.valueOf(skip));
                len += 1;
            }
            if (map.containsKey(len) == false) {
                map.put(len, new ArrayList<String>());
            }
            map.get(len).add(now.toString());
        } else {
            char c = target.charAt(pos);
            search(map, target, now, pos + 1, skip + 1, len);
            now.setLength(l);
            if (skip > 0) {
                now.append(String.valueOf(skip));
                now.append(c);
                search(map, target, now, pos + 1, 0, len + 2);
            } else {
                now.append(c);
                search(map, target, now, pos + 1, 0, len + 1);
            }
        }
        now.setLength(l);
    }

    public boolean ok(int pos, HashMap<Integer, List<String>> map, String[] dictionary) {
        String ret = "";
        List<String> list = map.get(pos);
        for (String string : list) {
            if (check(string, dictionary)) {
                ret = string;
                break;
            }
        }
        if (ret.length() > 0) {
            list = new ArrayList<String>();
            list.add(ret);
            map.put(pos, list);
            return true;
        } else {
            return false;
        }
    }

    public boolean check(String s, String[] dictionary) {
        for (String d : dictionary) {
            if (match(s, d)) {
                return false;
            }
        }
        return true;
    }

    public boolean match(String s, String d) {
        int dd = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dd >= d.length()) {
                return false;
            }
            if (Character.isDigit(s.charAt(i))) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i ++;
                }
                int gap = Integer.parseInt(s.substring(start, i --));
                dd += gap;
            } else {
                if (s.charAt(i) != d.charAt(dd)) {
                    return false;
                } else {
                    dd ++;
                }
            }
        }
        return dd == d.length();
    }
}