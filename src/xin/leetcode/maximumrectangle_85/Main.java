package xin.leetcode.maximumrectangle_85;

/**
 * Created by Xin on 10/30/2016.
 */
public class Main {
    public static void main(String[] args) {
        char[][] matrix = { {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(new Solution().maximalRectangle(matrix));
    }
}
