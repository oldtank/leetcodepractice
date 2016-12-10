package xin.leetcode.gameoflife_289;

/**
 * Created by Xin on 8/31/2016.
 */
public class Solution {
    static final int neighbours[][] = {{-1,-1},{-1,0},{-1,1},
            {0,-1},{0,1},
            {1,-1},{1,0},{1,1}};
    public void gameOfLife(int[][] board) {

    }

    public int countNeighbours(int[][] board, int i, int j) {
        int M = board.length;
        int N = board[0].length;
        int count = 0;
        for (int[] neighbour : neighbours) {
            int ni = i + neighbour[0];
            int nj = j + neighbour[1];
            if (ni>=0 && ni < M && nj >=0 && nj < N && board[ni][nj] % 2 == 1) {
                count ++;
            }
        }
        return count;
    }
}
