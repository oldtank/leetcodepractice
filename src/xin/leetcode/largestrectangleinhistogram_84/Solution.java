package xin.leetcode.largestrectangleinhistogram_84;

import java.util.Stack;

/**
 * Created by Xin on 10/30/2016.
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        Stack<Integer> posStack = new Stack<>();
        Stack<Integer> heightStack = new Stack<>();
        posStack.push(0);
        heightStack.push(heights[0]);
        for (int i=1; i<heights.length; i++) {
            int start = i;
            while (!heightStack.isEmpty() && heights[i] < heightStack.peek()) {
                start = posStack.peek();
                int area = heightStack.pop()*(i-posStack.pop());
                max = Math.max(area, max);
            }
            heightStack.push(heights[i]);
            posStack.push(start);
//            System.out.println("dummy");
        }
        while (!heightStack.isEmpty()) {
            int area = heightStack.pop() * (heights.length - posStack.pop());
            max = Math.max(area, max);
        }
        return max;
    }
}
