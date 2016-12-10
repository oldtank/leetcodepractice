package xin.leetcode.minimumuniquewordabbr_411;

/**
 * Created by Xin on 10/3/2016.
 */
public class Main {
    public static void main(String[] args) {
        String word = "leetcoders";
        String[] dict = {"abs"};
        System.out.println(new Solution().minAbbreviation(word, dict));
//        System.out.println(new Solution1().minAbbreviation(word, dict));
    }
}
