package xin.leetcode.maximalrectangle_85;

/**
 * Created by Xin on 10/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix= {
                {0,0,0,1,0,0,0},
                {0,0,1,1,1,0,0},
                {0,1,1,1,1,1,0}
        };
        System.out.println(new Solution().maximalRectangle(matrix));
    }
}
