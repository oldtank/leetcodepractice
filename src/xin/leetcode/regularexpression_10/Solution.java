package xin.leetcode.regularexpression_10;

/**
 * Created by Xin on 9/8/2016.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        //dp[i][j]: s up to char i-1 matching with p up to char j-1

        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        //empty string and pattern match
        dp[0][0] = true;
        for (int j=1; j<=p.length(); j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = true;
            }
        }

        for (int i=1; i<=s.length(); i++) {
            for (int j=1; j<=p.length(); j++) {
                if (p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                    System.out.println("i: "+i +", j:" + j + ", s: " + s.substring(0, i) + ", p: "+p.substring(0,j) + ", match:: " + dp[i][j]);
                } else if (p.charAt(j-1) == '*') {
                    if (p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2)) {
                        dp[i][j] = dp[i][j-2] ||
                                dp[i][j-1] ||
                                dp[i-1][j];
                        System.out.println("i: "+i +", j:" + j + ", s: " + s.substring(0, i) + ", p: "+p.substring(0,j) + ", match:: " + dp[i][j]);
                    } else {
                        // matching zero
                        dp[i][j] = dp[i][j-2];
                        System.out.println("i: "+i +", j:" + j + ", s: " + s.substring(0, i) + ", p: "+p.substring(0,j) + ", match:: " + dp[i][j]);
                    }
                } else if (p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                    System.out.println("i: "+i +", j:" + j + ", s: " + s.substring(0, i) + ", p: "+p.substring(0,j) + ", match:: " + dp[i][j]);
                }
            }
        }

        return dp[s.length()][p.length()];
    }


}
