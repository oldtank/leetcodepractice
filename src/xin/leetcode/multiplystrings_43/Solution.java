package xin.leetcode.multiplystrings_43;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 10/6/2016.
 */
public class Solution {
//    public String multiply(String num1, String num2) {
//        int m = num1.length();
//        int n = num2.length();
//        int[] pos = new int[m+n];
//        for (int i=0; i<m;i++) {
//            for (int j=0; j<n; j++) {
//                int curr = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
//
//            }
//        }
//    }

    public String multiply(String num1, String num2) {
        if (num2.equals("0") || num1.equals("0")) {
            return "0";
        }
        if (num2.length() > num1.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        if (num2.equals("1")) {
            return num1;
        }
        List<StringBuilder> results = new ArrayList<>();
        int max_length = Integer.MIN_VALUE;
        for (int i=num2.length()-1; i>=0; i--) {
            StringBuilder tmp = multiplySingle(num1, num2.charAt(i));
            if (tmp.length() == 0) {
                continue;
            }
            for (int j=0; j<num2.length()-1-i; j++) {
                tmp.append('0');
            }
            results.add(tmp);
            max_length = Math.max(max_length, tmp.length());
        }
        for (int i=0; i<results.size(); i++) {
            StringBuilder zeros = new StringBuilder();
            for (int j=0; j<max_length - results.get(i).length(); j++) {
                zeros.append("0");
            }
            System.out.println(results.get(i));
        }

        StringBuilder r = new StringBuilder();
        int carry = 0;
        for (int i=max_length-1; i>=0; i--) {
            int curr = 0;
            for (int j=0; j<results.size(); j++) {
                curr += (results.get(j).charAt(i) - '0');
            }
            curr += carry;
            r.insert(0, curr % 10);
            carry = curr / 10;
        }
        if (carry > 0) {
            r.insert(0, carry);
        }
        return r.toString();

    }

    StringBuilder multiplySingle(String num1, char digit) {
        if (digit == '0') {
            return new StringBuilder();
        }
        if (digit == '1') {
            return new StringBuilder(num1);
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int iDigit = digit - '0';
        for (int i=num1.length()-1; i>=0; i--) {
            int curr = (num1.charAt(i) - '0') * iDigit + carry;
            sb.insert(0, curr % 10);
            carry = curr / 10;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb;
    }
}