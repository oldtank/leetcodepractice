package xin.leetcode.spiralmatrix_54;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
public class Solution {
    int move_i[] = {0, 1, 0, -1};
    int move_j[] = {1, 0, -1, 0};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return list;
        }
        int m = matrix.length, n = matrix[0].length;
        int start_i = 0, start_j = 0, curr_m = m, curr_n=n;
        while (curr_m >0 && curr_n>0) {
            list.addAll(printHelper(matrix, start_i, start_j, curr_n, 0));
            list.addAll(printHelper(matrix, start_i+1, start_j+curr_n-1, curr_m-1, 1));
            if (curr_m-1>0) {
                list.addAll(printHelper(matrix, start_i + curr_m - 1, start_j + curr_n - 2, curr_n - 1, 2));
            }
            if (curr_n-1>0) {
                list.addAll(printHelper(matrix, start_i + curr_m - 2, start_j, curr_m - 2, 3));
            }

            curr_m-=2;
            curr_n-=2;
            start_j++;
            start_i++;
        }
        return list;
    }

    public List<Integer> printHelper(int[][] matrix, int start_i, int start_j, int length, int direction) {
        List<Integer> list = new ArrayList<>();
        for (int tmp=0; tmp<length; tmp++) {
            list.add(matrix [start_i + move_i[direction] * tmp][start_j + move_j[direction] * tmp]);
        }
        return list;
    }
}