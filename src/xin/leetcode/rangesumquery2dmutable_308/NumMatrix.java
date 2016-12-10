package xin.leetcode.rangesumquery2dmutable_308;

/**
 * Created by Xin on 10/1/2016.
 */
public class NumMatrix {
    FenwickTree[] trees;
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        trees = new FenwickTree[matrix.length];
        for (int i=0; i<matrix.length; i++) {
            trees[i] = new FenwickTree(matrix[i]);
        }
        this.matrix = matrix;
    }

    public void update(int row, int col, int val) {
        trees[row].increment(col, val - matrix[row][col]);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i=row1; i<=row2; i++) {
            sum += trees[i].getSum(col2) - trees[i].getSum(col1-1);
        }
        return sum;
    }

    class FenwickTree {
        int[] ft;

        public FenwickTree(int[] nums) {
            int n = nums.length;
            ft = new int[n+1];

            for (int i=0; i<nums.length; i++) {
                increment(i, nums[i]);
            }
        }

        public void update(int i, int val) {
            increment(i, val - ft[i+1]);
        }

        public void increment(int i, int toAdd) {
            i++;
            while (i < ft.length) {
                ft[i] += toAdd;
                i += (i & -1 * i);
            }
        }

        public int getSum(int i) {
            i++;
            int sum = 0;
            while (i > 0) {
                sum += ft[i];
                i -= (i & -1 * i);
            }
            return sum;
        }
    }
}
