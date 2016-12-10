package xin.leetcode.bombenemy_361;

/**
 * Created by Xin on 9/3/2016.
 */
public class Main {
    public static void main(String[] args) {
        char[][] grid = {{'0','E','0','0'},
                {'E','0','W','E'},
                {'0','E','0','0'}};
        System.out.println(new Solution().maxKilledEnemies(grid));
    }
}
