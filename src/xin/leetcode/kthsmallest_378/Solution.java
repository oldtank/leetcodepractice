package xin.leetcode.kthsmallest_378;

/**
 * Created by Xin on 9/1/2016.
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int sqrt = (int) Math.sqrt(k);
        if (k == sqrt*sqrt) {
            return matrix[sqrt-1][sqrt-1];
        }

        k = k-(sqrt*sqrt);
        int i=0, j=0;
        while (k>=2) {
            if (i > sqrt + 1) {
                j++;
            } else if (j > sqrt) {
                i++;
            } else {
                if (matrix[i][sqrt] < matrix[sqrt][j]) {
                    i++;
                } else {
                    j++;
                }
            }
            k--;
        }
        if (i > sqrt+1) {
            return matrix[sqrt][j];
        } else if (j>sqrt) {
            return matrix[i][sqrt];
        } else {
            return Math.min(matrix[i][sqrt], matrix[sqrt][j]);
        }
    }
}