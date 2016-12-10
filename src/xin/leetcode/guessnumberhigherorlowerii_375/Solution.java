package xin.leetcode.guessnumberhigherorlowerii_375;

/**
 * Created by Xin on 9/5/2016.
 */
public class Solution {
    public int getMoneyAmount(int n) {
        int costs[][] = new int[n+1][n+1];
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                costs[i][j] = 0;
            }
        }
        for (int i=1; i<=n-1;i++) {
            costs[i][i+1] = i;
        }

        for (int span=2; span<=n-1; span++) {
            for (int i=1; i+span<=n; i++) {
                System.out.println("checking cost of "+i+" to "+(i+span));
                int cost = Math.min(i+costs[i+1][i+span], costs[i][i+span-1]+(i+span));
                System.out.println("cost is initialized: "+cost);
                for (int j=i+1; j<=i+span-1; j++) {
                    cost = Math.min(cost, j+ Math.max(costs[i][j-1], costs[j+1][i+span]));
                }
                System.out.println("cost is finalized: "+cost+"\n");
                costs[i][i+span] = cost;
            }
        }

        return costs[1][n];
    }

}