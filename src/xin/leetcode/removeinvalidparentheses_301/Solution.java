package xin.leetcode.removeinvalidparentheses_301;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 11/16/2016.
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        List<String> good = new ArrayList<>();
        List<String> intermediate = new ArrayList<>();

        helperFromLeft(good, intermediate, s, 0, 0);
        System.out.println(good);
        System.out.println(intermediate);
        return result;
    }

    void helperFromLeft(List<String> good, List<String> intermediate, String s, int net, int pos) {
        if (pos == s.length()) {
            if (net == 0) {
                good.add(s);
                return;
            } else if (net > 0) {
                intermediate.add(s);
                return;
            }
        }
        if (s.charAt(pos) == '(') {
            helperFromLeft(good, intermediate, s, net+1, pos+1);
        } else if (s.charAt(pos) == ')') {
            if (net == 0) {
                for (int i=0; i<=pos; i++) {
                    if (s.charAt(i) == ')' && (i==0 || s.charAt(i-1)!=')')) {
                        System.out.println("remove pos " + i + " from string " + s);
                        helperFromLeft(good, intermediate, s.substring(0, i) + s.substring(i + 1), net, pos);
                    }
                }
            } else {
                helperFromLeft(good, intermediate, s, net-1, pos+1);
            }
        } else {
            helperFromLeft(good, intermediate, s, net, pos+1);
        }
    }

    public void helper(String s, List<String> result) {
        String orig = s;
        int net = 0;
        int pos = 0;
//        StringBuilder sb = new StringBuilder(s);
        while (pos < s.length()) {
            if (s.charAt(pos) == '(') {
                net++;
            } else if (s.charAt(pos) == ')') {
                net --;
            }
            if (net < 0) {
//                System.out.println("remove ) from string " + s);
                s = s.substring(0, pos) + s.substring(pos+1);
                net++;
            } else {
                pos++;
            }
        }
        if (net == 0) {
            result.add(s);
            reverseHelper(orig, result);
        } else {
            reverseHelper(s, result);
        }
    }

    public void reverseHelper(String s, List<String> result) {
        int net = 0;
        int pos = s.length()-1;
//        StringBuilder sb = new StringBuilder(s);
        while (pos >=0 ) {
            if (s.charAt(pos) == ')') {
                net++;
            } else if (s.charAt(pos) == '(') {
                net --;
            }
            if (net < 0) {
//                System.out.println("remove ) from string " + s);
                s = s.substring(0, pos) + s.substring(pos+1);
                net++;
            } else {
                pos--;
            }
        }
        if (net == 0) {
            result.add(s);
        }
    }
}