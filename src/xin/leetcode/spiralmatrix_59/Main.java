package xin.leetcode.spiralmatrix_59;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 https://leetcode.com/problems/spiral-matrix-ii/
 */
public class Main {
    public static void main(String[] args) {
        int size = 5;
        int matrix[][] = generateMatrix(size);
        print(matrix);
    }

    public static void print(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int curr = 0, start=1;
        while (n>=1) {
            helper(matrix, curr, curr, n, start);
            start += 4*n-4;
            n-=2;
            curr++;
        }

        return matrix;
    }

    // draw a spiral frame of size $size from n[i][j], starting from number $num
    public static void helper(int[][] n, int i, int j, int size, int num) {
        //$size number to the right
        for (int offset=0; offset<size; offset++) {
            n[i][j+offset] = num++;
        }
        // $size-1 numbers down
        for (int offset=1; offset<size; offset++) {
            n[i+offset][j+size-1] = num++;
        }

        // $size-1 numbers left
        for (int offset=size-2; offset>=0; offset--) {
            n[i+size-1][j+offset] = num++;
        }

        // $size-2 numbers up
        for (int offset=size-2; offset>=1; offset--) {
            n[i+offset][j] = num++;
        }
    }
}
