package xin.dynamicprogramming.longest_palindrome_sequence;

import xin.general.TwoDimMatrix;

import java.util.ArrayList;

/**
 * Created by Xin on 7/28/2016.
 */
public class LongestPalindromeSequence {
    public static void main(String[] args) {
        String s = "GEEKS FOR GEEKS";
        System.out.println(findLongestSequence(s));
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int findLongestSequence(String s, TwoDimMatrix<Integer> result, int left, int right) {
        if (result.get(left, right) != null) {
            return result.get(left, right);
        }
        if (s.charAt(left) == s.charAt(right)) {
            return 2 + findLongestSequence(s, result, left + 1, right - 1);
        } else {
            return max(findLongestSequence(s, result, left + 1, right), findLongestSequence(s, result, left, right - 1));
        }
    }

    public static int findLongestSequence(String s) {
        TwoDimMatrix<Integer> result = new TwoDimMatrix<Integer>(s.length(), s.length());
        for (int i=0; i<result.getColSize(); i++) {
            result.set(i, i, 1);
            if (i < result.getColSize() - 1) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    result.set(i, i+1, 2);
                } else {
                    result.set(i, i+1, 1);
                }
            }
        }
        return findLongestSequence(s, result, 0, s.length()-1);
    }
}
