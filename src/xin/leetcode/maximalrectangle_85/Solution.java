package xin.leetcode.maximalrectangle_85;

import java.util.Arrays;

/**
 * Created by Xin on 10/11/2016.
 */
public class Solution {
    public int maximalRectangle(int[][] matrix) {
        if(matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int left[]=new int[n], right[]=new int[n], height[]=new int[n];
        Arrays.fill(right,n); //left and height will be default having values 0
        int maxA = 0;
        for(int i=0; i<m; i++) {
            int cur_left=0, cur_right=n-1;
            for(int j=0; j<n; j++) { // compute height (can do this from either side)
                if(matrix[i][j]==1) {
                    height[j]++;
                }
                else {
                    height[j]=0;
                }
            }
            for(int j=0; j<n; j++) { // compute left (from left to right)
                if(matrix[i][j]==1) {
                    left[j] = Math.max(left[j], cur_left);
                }
                else {
                    left[j]=0; cur_left=j+1;
                }
            }
            // compute right (from right to left)
            for(int j=n-1; j>=0; j--) {
                if(matrix[i][j]==1) {
                    right[j]=Math.min(right[j],cur_right);
                }
                else {
                    right[j]=n-1; cur_right=j-1;
                }
            }
            System.out.println("dummy");
            // compute the area of rectangle (can do this from either side)
            for(int j=0; j<n; j++) {
                maxA = Math.max(maxA, (right[j] - left[j] + 1) * height[j]);
            }
        }
        return maxA;
    }
}