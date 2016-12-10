package xin.ctci.c11q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Xin on 8/23/2016.
 */
public class SortAnagram {

    public static void main(String[] args) {
        String[] strings = {"z", "ab", "abc", "ba", "eoq", "cba", "qoe"};
        System.out.println(sortAnagram(strings));
    }

    public static ArrayList<String> sortAnagram(String[] strings) {
        HashMap<String, ArrayList<String>> codeToStringMap = new HashMap<>();
        for (String s : strings) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String key = new String(sArray);
            codeToStringMap.putIfAbsent(key, new ArrayList<>());
            codeToStringMap.get(key).add(s);
        }

        ArrayList<String> sorted = new ArrayList<>();
        for (String key : codeToStringMap.keySet()) {
            sorted.addAll(codeToStringMap.get(key));
        }
        return sorted;
    }
}
