package xin.leetcode.integerreplacement_397;

/**
 * Created by Xin on 10/12/2016.
 */
public class Solution {
    public int integerReplacement(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n+2];
        for (int i=0; i<=n+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;
        dp[2] = 1;
        for (int i=2; i<=n+1; ) {
            if (i%2 == 0) {
                if (i*2 <= n+1) {
                    dp[i*2] = Math.min(dp[i*2], 1+dp[i]);
                }
                if (i+1 <= n+1) {
                    dp[i+1] = Math.min(dp[i+1], 1+dp[i]);
                }
                if (i-1>1) {
                    if (dp[i-1] <= dp[i]+1) {
                        i++;
                    } else {
                        dp[i-1] = 1 + dp[i];
                        i=i-1;
                    }
                } else {
                    i++;
                }
            } else {
                if (i*2 <=n+1) {
                    dp[i*2] = Math.min(dp[i*2], 1+dp[i]);
                }
                i++;
            }
        }

        return dp[n];
    }
}