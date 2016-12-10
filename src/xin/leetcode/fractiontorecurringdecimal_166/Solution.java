package xin.leetcode.fractiontorecurringdecimal_166;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 9/1/2016.
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        double int_part_d = (double)numerator/denominator ;
        if (int_part_d %1==0) {
            return ""+int_part_d;
        }
        sb.append((int)numerator/denominator);
        int currRemainder = numerator%denominator;
        if (currRemainder == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder fraction = new StringBuilder();
        while (currRemainder != 0) {
            if (map.get(currRemainder) == null) {
                map.put(currRemainder, fraction.length());
                fraction.append(currRemainder*10/denominator);
                currRemainder = currRemainder*10%denominator;
            } else {
                fraction.insert(map.get(currRemainder), "(");
                fraction.append(")");
                break;
            }
        }
        return sb.append(fraction).toString();
    }
}
