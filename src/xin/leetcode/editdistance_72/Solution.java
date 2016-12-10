package xin.leetcode.editdistance_72;

/**
 * Created by Xin on 9/18/2016.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word2.length() == 0) {
            return word1.length();
        }
        if (word1.length() == 0) {
            return word2.length();
        }

        int M = word1.length();
        int N = word2.length();
        int dp[][] = new int[M][N];
        if (word1.charAt(M-1) == word2.charAt(N-1)) {
            dp[M-1][N-1] = 0;
        } else {
            dp[M-1][N-1] = 1;
        }
        for (int i=M-2; i>=0; i--) {
            dp[i][N-1] = Math.min(dp[i+1][N-1]+1, (word1.charAt(i) == word2.charAt(N-1) ? (M-1-i) : (M-i)) );
        }
        for (int j=N-2; j>=0; j--) {
            dp[M-1][j] = Math.min(dp[M-1][j+1]+1, (word1.charAt(M-1) == word2.charAt(j) ? (N-1-j):(N-j)) );
        }

        for (int i=M-2; i>=0; i--) {
            for(int j=N-2; j>=0; j--) {
                int distance;
                if (word1.charAt(i) == word2.charAt(j)) {
                    distance = dp[i+1][j+1];
                } else {
                    distance = 1+dp[i+1][j+1];
                }
                distance = Math.min(distance, dp[i+1][j]+1);
                distance = Math.min(distance, dp[i][j+1]+1);
                dp[i][j] = distance;
            }
        }

        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[0][0];
    }
}