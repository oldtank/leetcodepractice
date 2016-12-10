package xin.leetcode.minimumwindowsubstring_76;

/**
 * Created by Xin on 10/6/2016.
 */
public class Main {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(new Solution().minWindow1(s, t));
    }
}
