package xin.ctci.c1q5;

/**
 * Created by Xin on 8/18/2016.
 */
public class StringCompress {
    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(compress(s));
    }

    public static String compress(String s) {
        String result = "";
        int i=0;
        int curr_count = 1;
        result += s.charAt(i++);
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(i-1)) {
                curr_count ++;
            } else {
                result += curr_count;
                result += s.charAt(i);
                curr_count = 1;
            }
            if (i == s.length() - 1) {
                result += curr_count;
            }
            i++;
        }
        return result.length() < s.length() ? result : s;
    }
}
