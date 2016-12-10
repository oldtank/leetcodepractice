package xin.leetcode.textjustification_68;

import java.util.List;

/**
 * Created by Xin on 11/19/2016.
 */
public class Main {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxLength = 16;
        List<String> justified = new Solution().fullJustify(words, maxLength);
        justified.forEach(line -> System.out.println(line));
    }
}
