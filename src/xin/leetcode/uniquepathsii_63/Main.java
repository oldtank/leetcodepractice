package xin.leetcode.uniquepathsii_63;

/**
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 https://leetcode.com/problems/unique-paths-ii/
 */
public class Main {

    public static void main(String[] args) {
        int obstacleGrid[][] = { {0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    public static  int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int matrix[][] = new int[m][n];
        if (obstacleGrid[0][0] == 0) {
            matrix[0][0] = 1;
        }
        for (int i=1; i<m; i++) {
            if (obstacleGrid[i][0] != 1) {
                matrix[i][0] = matrix[i-1][0];
            }
        }
        for (int j=1; j<n; j++) {
            if (obstacleGrid[0][j] != 1) {
                matrix[0][j] = matrix[0][j-1];
            }
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    matrix[i][j] = (obstacleGrid[i - 1][j] == 1 ? 0 : matrix[i - 1][j]) +
                            (obstacleGrid[i][j-1] == 1? 0 : matrix[i][j-1]);
                }
            }
        }
        return matrix[m-1][n-1];
    }
}
