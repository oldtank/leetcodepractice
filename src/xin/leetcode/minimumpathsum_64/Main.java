package xin.leetcode.minimumpathsum_64;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom
 * right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 https://leetcode.com/problems/minimum-path-sum/
 */
public class Main {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int paths[][] = new int[m][n];
        paths[0][0] = grid[0][0];
        for (int i=1; i<m; i++) {
            paths[i][0] = grid[i][0] + paths[i-1][0];
        }
        for (int j=1; j<n; j++) {
            paths[0][j] = grid[0][j] + paths[0][j-1];
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                paths[i][j] = grid[i][j] + min(paths[i-1][j], paths[i][j-1]);
            }
        }
        return paths[m-1][n-1];
    }

    public int min(int a, int b) {
        return a<b?a:b;
    }
}
