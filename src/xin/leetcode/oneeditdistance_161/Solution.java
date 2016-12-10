package xin.leetcode.oneeditdistance_161;

/**
 * Created by Xin on 10/5/2016.
 */
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) >= 2) {
            return false;
        }

        for (int i=0; i< Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i+1).equals(t.substring(i+1));
                } else if (s.length() > t.length()) {
                    return s.substring(i+1).equals(t.substring(i));
                } else {
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }

        return Math.abs(s.length() - t.length()) == 1;
    }

    public boolean isOneEditDistance1(String s, String t) {
        if (s.equals(t)) {
            return false;
        }
        if (s.indexOf(t) >=0 && s.length()-t.length()==1) {
            return true;
        }
        if (t.indexOf(s) >=0 && t.length() - s.length() == 1) {
            return true;
        }
        if (Math.abs(s.length()-t.length()) > 1) {
            return false;
        }
        int M = s.length();
        int N = t.length();
        int dp[][] = new int[M+1][N+1];
        // dp[i][j]: edit distance of string length i and j
        dp[0][0] = 0;
        for (int i=1; i<=M; i++) {
            dp[i][0] = i;
        }
        for (int j=1; j<=N; j++) {
            dp[0][j]=j;
        }
        for (int i=1; i<=M; i++) {
            for (int j=1; j<=N; j++) {
                int d = Integer.MAX_VALUE;
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    d = dp[i-1][j-1];
                } else {
                    d = 1 + dp[i-1][j-1];
                }

                d = Math.min(d, 1 + dp[i-1][j]);
                d = Math.min(d, 1 + dp[i][j-1]);

                dp[i][j] = d;
//                System.out.println(i +","+j+": "+d);
            }
        }
        return dp[M][N] == 1;
    }
}