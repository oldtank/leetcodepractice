package xin.leetcode.groupshiftedstrings_249;

import java.util.List;

/**
 * Created by Xin on 9/25/2016.
 */
public class Main {
    public static void main(String[] args) {
        String strings[] = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> list = new Solution().groupStrings(strings);

        for (List<String> l : list) {
            System.out.println(l);
        }
    }
}
