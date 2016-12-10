package xin.leetcode.wildcardmatching_44;

/**
 * Created by Xin on 9/9/2016.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0) {
            if ("*".equals(p) || "".equals(p)) {
                return true;
            } else {
                return false;
            }
        }

        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        int n=s.length(), m=p.length();

        //dp[* > 0][0] all false

        for (int j=1; j<=p.length(); j++) {
            dp[0][j] = dp[0][j-1] && p.charAt(j-1) == '*';
        }

        for (int i=1; i<=s.length(); i++) {
            for (int j=1; j<=p.length(); j++) {
                if (p.charAt(j-1) != '*') {
                    dp[i][j] = dp[i-1][j-1] && (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1));
                    System.out.println(s.substring(0, i) + " and "+p.substring(0, j) +": " + dp[i][j]);
                } else {
                    if (j==1) {
                        dp[i][j] = true;
                    } else {
                        boolean tmp = false;
                        for (int x = 1; x <= i; x++) {
                            tmp = tmp || dp[x][j - 1];
                        }
                        dp[i][j] = tmp;
                    }
                    System.out.println(s.substring(0, i) + " and "+p.substring(0, j) +": " + dp[i][j]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean helper(String s, int si, String p, int pi) {
        if ( si != s.length() && pi == p.length()) {
            return false;
        }
        if (si == s.length() && pi != p.length()) {
            if (p.charAt(pi) == '*') {
                return helper(s, si, p, pi+1);
            } else {
                return false;
            }
        }
        if (si == s.length() && pi == p.length()) {
            return true;
        }

        char sc = s.charAt(si);
        char pc = p.charAt(pi);
        if (pc != '?' && pc != '*') {
            if (sc == pc) {
                return helper(s, si+1, p, pi+1);
            } else {
                return false;
            }
        } else if (pc == '?') {
            return helper(s, si+1, p, pi+1);
        } else {
            for (int i=si; i<=s.length(); i++) {
                if (helper(s, i, p, pi+1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
