package xin.leetcode.numberofislands_200;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3

 https://leetcode.com/problems/number-of-islands/
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char grid[][] = { {'1','0','0','1'}, {'0','1','1','0'}, {'0','0','0','0'}};
        System.out.println(solution.numIslands(grid));
    }
}
