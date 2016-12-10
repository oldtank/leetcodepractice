package xin.leetcode.reversevowels_345;

/**
 * Created by Xin on 8/29/2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    public static String reverseVowels(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        int left = nextVowel(0, s), right = prevVowel(s.length()-1, s);
        while (left >= 0 && right >= 0 && left < right) {
            char tmp = s.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, tmp);

            left = nextVowel(left+1, s);
            right = prevVowel(right-1,s);
        }
        return sb.toString();
    }

    public  static int nextVowel(int i, String s) {
        while(i < s.length()) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
                    || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
                break;
            }
            i++;
        }
        if (i==s.length()) {
            return -1;
        } else {
            return i;
        }
    }

    public static int prevVowel(int i, String s) {
        while (i >=0) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
                    || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
                break;
            }
            i--;
        }
        if (i < 0) {
            return -1;
        } else {
            return i;
        }
    }
}
