package xin.interview.backpack;

/**
 * Created by Xin on 10/8/2016.
 */
public class Backpack {
    public int findMaxValue(int capacity, int[] values, int[] weights) {
        if (capacity == 0) {
            return 0;
        }

        int N = values.length;
        int[][] dp = new int[capacity+1][N+1];
        for (int i=1; i<=capacity;i++) {
            for (int j=1; j<=N; j++) {
                dp[i][j] = dp[i][j-1];
                if (i >= weights[j-1]) {
                    dp[i][j] = Math.max(dp[i][j], values[j-1] + dp[i-weights[j-1]][j-1]);
                }
            }
        }

        return dp[capacity][N];
    }
}
