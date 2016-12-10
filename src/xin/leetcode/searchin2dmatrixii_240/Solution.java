package xin.leetcode.searchin2dmatrixii_240;

/**
 * Created by Xin on 9/3/2016.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int M = matrix.length, N = matrix[0].length;
        int x = M-1, y=0;
        while (x>=0 && y<=N-1) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }

//    public boolean helper(int[][] matrix, int target, int fromi, int fromj, int toi, int toj) {
//
//    }
}