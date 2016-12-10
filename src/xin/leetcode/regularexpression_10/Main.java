package xin.leetcode.regularexpression_10;

/**
 * Created by Xin on 9/25/2016.
 */
public class Main {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*b";
        System.out.println(new Solution().isMatch(s, p));
    }
}
