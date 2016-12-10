package xin.leetcode.decodeways_91;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 */
public class Main {

    public static void main(String[] s) {
        System.out.println(numDecodings("00"));
    }

    public static int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        // count[i]: number of decoding ways of substring of length i (ending at i-1)
        int[] count = new int[s.length()+1];
        count[0] = 1;
        for (int i=1; i<= s.length(); i++) {
            if (s.charAt(i-1) > '0' && s.charAt(i-1) <= '9') {
                count[i] = count[i-1];
            }
            if (i>=2) {
                String lastTwo = s.substring(i-2, i);
                if (Integer.parseInt(lastTwo) > 9 && Integer.parseInt(lastTwo) <= 26) {
                    count[i] += count[i-2];
                }
            }
        }
        return count[s.length()];
    }

    public static int numDecodings1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int count[] = new int[s.length()+1];
        for (int i=0; i<=s.length(); i++) {
            count[i] = 0;
        }
        count[0] = 1;
        if(s.charAt(s.length()-1) >='1' && s.charAt(s.length()-1) <='9') {
            count[1]=1;
        }

        for (int i=s.length()-2; i>=0; i--) {
            String front = s.substring(i,i+1);
            if (Integer.parseInt(front) >0) {
                count[s.length()-i] += count[s.length()-i-1];
            }
            front = s.substring(i, i+2);
            if (Integer.parseInt(front) >9 && Integer.parseInt(front)<=26) {
                count[s.length()-i] += count[s.length()-i-2];
            }
        }
        return count[s.length()];
    }
}
