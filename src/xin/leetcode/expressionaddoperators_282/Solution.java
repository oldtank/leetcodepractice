package xin.leetcode.expressionaddoperators_282;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/19/2016.
 */
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        helper("", 0, 0, num, target, list);

        list.forEach(s -> System.out.println(s));
        return list;
    }

    public void helper(String expression, int result, int prev_last, String num, int target, List<String> list) {
        System.out.println("exp: "+expression + "; result: "+result+"; prev: "+prev_last + "; target: "+target);

        if (num.length() == 0 && result == target) {
            list.add(expression);
        }

        for (int i=1; i<=num.length(); i++) {
            String first_num = num.substring(0, i);
            if (first_num.startsWith("0") && first_num.length() > 1) {
                return;
            }
            int first_num_i = Integer.parseInt(num.substring(0, i));
            String remaining = num.substring(i);

            if (expression.length() == 0) {
                helper(first_num, first_num_i, first_num_i, remaining, target, list);
            } else {
                helper(expression+"+"+first_num, result+first_num_i, first_num_i, remaining, target, list);
                helper(expression+"-"+first_num, result-first_num_i, -1*first_num_i, remaining, target, list);
                helper(expression+"*"+first_num, result-prev_last+prev_last*first_num_i, prev_last*first_num_i, remaining,
                        target, list);
            }
        }
    }
}