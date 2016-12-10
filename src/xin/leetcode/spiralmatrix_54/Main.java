package xin.leetcode.spiralmatrix_54;

import java.util.Stack;

/**
 * Created by Xin on 9/1/2016.
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Solution solution = new Solution();
        int matrix[][] = {{2,3}};
        System.out.println(solution.spiralOrder(matrix));
    }
}
