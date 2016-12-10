package xin.leetcode.substringkdistinctchar_340;

/**
 * Created by Xin on 9/8/2016.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "1ecebaa23";
        int k= 4;

        System.out.println(solution.lengthOfLongestSubstringKDistinct(s, k));
    }
}
