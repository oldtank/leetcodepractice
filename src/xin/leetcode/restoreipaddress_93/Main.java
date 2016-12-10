package xin.leetcode.restoreipaddress_93;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by Xin on 8/28/2016.Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

 https://leetcode.com/problems/restore-ip-addresses/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("0000"));
    }

    public static List<String> restoreIpAddresses(String s) {
        return restoreHelper(s, 4);
    }

    public static List<String> restoreHelper(String s, int segmentsNeeded) {
        if (s.length() == 0) {
            if (segmentsNeeded == 0) {
                List<String> list = new ArrayList<>();
                list.add("");
                return list;
            } else {
                return new ArrayList<>();
            }
        } else {
            if (segmentsNeeded == 0) {
                return new ArrayList<>();
            }
        }
        List<String> list = new ArrayList<>();

        for (int i=s.length()-1; i>=0 && i>=s.length()-3; i--) {
            String curr = s.substring(i);
            if (Integer.parseInt(curr) >=0 && Integer.parseInt(curr) <=255 && isValidNumber(curr)) {
                List<String> sublists = restoreHelper(s.substring(0, i), segmentsNeeded-1);
                for (String sub : sublists) {
                    if (sub.equals("")) {
                        sub=curr;
                    } else {
                        sub += "." + curr;
                    }
                    list.add(sub);
                }
            }
        }
        return list;
    }

    public static boolean isValidNumber(String s) {
        return s.equals("0") || s.charAt(0) != '0';
    }
}
