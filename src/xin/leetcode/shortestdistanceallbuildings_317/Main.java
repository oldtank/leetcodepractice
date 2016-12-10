package xin.leetcode.shortestdistanceallbuildings_317;

/**
 * Created by Xin on 9/17/2016.
 */
public class Main {
    public static void main(String[] args) {
        int grid[][] = new int[3][5];
        grid[0][0] = 1;
        grid[0][4] = 1;
        grid[2][2] = 1;
        grid[0][2] = 2;

        System.out.println(new Solution().shortestDistance(grid));
    }
}
