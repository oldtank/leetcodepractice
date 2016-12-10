package xin.leetcode.wordbreakii_140;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xin on 9/16/2016.
 */
public class Main {
    public static void main(String[] args) {
        String sentence = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String dict[] = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        Set<String> wordDict = new HashSet<>();
        for (String s : dict) {
            wordDict.add(s);
        }


    }
}
