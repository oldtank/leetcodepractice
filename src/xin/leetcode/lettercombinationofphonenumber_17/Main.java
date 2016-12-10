package xin.leetcode.lettercombinationofphonenumber_17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 8/28/2016.
 */
public class Main {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new Solution().letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        String numMappings[] = {" ", null, "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list = new ArrayList<>();
        helper(numMappings, digits, 0, new StringBuilder(), list);
        return list;
    }

    public static void helper(String[] numMappings, String digits, int pos, StringBuilder sb, List<String> list) {
        if (pos == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String candidates = numMappings[digits.charAt(pos) - '0'];
        for (int i=0; i<candidates.length(); i++) {
            sb.append(candidates.charAt(i));
            helper(numMappings, digits, pos+1, sb, list);
            sb.setLength(sb.length()-1);
        }

    }

//    public static List<String> letterCombinations(String digits) {
//        String numMappings[] = initialize();
//        if (digits.length() ==0) {
//            return new ArrayList<>();
//        }
//        for (int i=0;i<digits.length(); i++) {
//            if (digits.charAt(i) == '1') {
//                return new ArrayList<>();
//            }
//        }
//        return letterCombinations(digits, 0, numMappings);
//    }

    public static List<String> letterCombinations(String digits, int pos, String[] numMappings) {
        if (pos >= digits.length()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> subCombinations = letterCombinations(digits, pos+1, numMappings);
        List<String> lists = new ArrayList<>();
        String letters = numMappings[digits.charAt(pos)-'0'];
        for (int i=0;i<letters.length();i++) {
            for (String subCombination : subCombinations) {
                lists.add(letters.charAt(i)+subCombination);
            }
        }
        return lists;
    }

    public static String[] initialize() {
        String numMappings[] = {" ", null, "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return numMappings;
    }
}
