package xin.leetcode.removeinvalidparentheses_301;

/**
 * Created by Xin on 11/16/2016.
 */
public class Main {
    public static void main(String[] args) {
//        String s  = "(a)())()";
        String s = ")(";
        System.out.println(new Solution().removeInvalidParentheses(s));
    }
}
