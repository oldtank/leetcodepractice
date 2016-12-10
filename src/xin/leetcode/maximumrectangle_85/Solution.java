package xin.leetcode.maximumrectangle_85;

import java.util.Stack;

/**
 * Created by Xin on 10/30/2016.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int[] heights = new int[matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
            max = Math.max(max, findArea(heights));
        }
        return max;
    }

    private int findArea(int[] heights) {
        Stack<Integer> posStack = new Stack<>();
        Stack<Integer> heightStack = new Stack<>();

        posStack.push(0);
        heightStack.push(heights[0]);

        int max = Integer.MIN_VALUE;
        for (int i=1; i<heights.length; i++) {
            int from = i;
            while (!heightStack.isEmpty() && heights[i] < heightStack.peek()) {
                from = posStack.peek();
                int area = heightStack.pop() * (i - posStack.pop());
                max = Math.max(max, area);
            }
            posStack.push(from);
            heightStack.push(heights[i]);
        }

        while (!heightStack.isEmpty()) {
            max = Math.max(max, heightStack.pop() * (heights.length - posStack.pop()));
        }

        return max;
    }
}