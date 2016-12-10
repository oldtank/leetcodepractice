package xin.leetcode.search2dmatrix_74;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class Main {
    public static void main(String[] args) {
        int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,24,50}};
        int target=7;
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n= matrix[0].length;
        if (target > matrix[m-1][n-1] || target < matrix[0][0]) {
            return false;
        }
        int row = findCeilingInLastColumn(matrix, target, 0, m-1);
        if (row == -1) {
            if (matrix[m-1][n-1] == target) {
                return true;
            } else {
                return false;
            }
        } else {
            if (row >0 && matrix[row-1][n-1] == target) {
                return true;
            } else {
                return findInRow(matrix, target, row, 0, n - 1);
            }
        }
    }

    public static boolean findInRow(int[][] matrix, int target, int row, int left, int right) {
        if (left > right) {
            return false;
        }
        if (left == right) {
            return matrix[row][left] == target;
        }
        int mid = (left+right)/2;
        if (matrix[row][mid] == target) {
            return true;
        } else if (matrix[row][mid] < target) {
            return findInRow(matrix, target, row, mid+1, right);
        } else {
            return findInRow(matrix, target, row, left, mid-1);
        }
    }

    public static int findCeilingInLastColumn(int[][] matrix, int target, int top, int bottom) {
        int column = matrix[0].length-1;
        if (bottom < top) {
            return -1;
        }
        if (top == bottom) {
            if (matrix[top][column] > target) {
                return top;
            } else {
                return -1;
            }
        }
        int mid = (top+bottom)/2;
        if (matrix[mid][column] <= target) {
            return findCeilingInLastColumn(matrix, target, mid+1,bottom);
        } else {
            return findCeilingInLastColumn(matrix, target, top, mid);
        }
    }
}
