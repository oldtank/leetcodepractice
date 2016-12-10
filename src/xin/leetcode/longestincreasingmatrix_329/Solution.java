package xin.leetcode.longestincreasingmatrix_329;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/17/2016.
 */
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int M = matrix.length;
        int N = matrix[0].length;
        int length[][] = new int[M][N];
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                length[i][j] = -1;
            }
        }

        int[][] dp = new int[M][N];
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (dp[i][j] == 0) {
                    lengthStartingHere(matrix, i, j, dp);

                    for (int u=0; u<M; u++) {
                        for (int v = 0; v < N; v++) {
                            System.out.print(dp[u][v] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
        }
        int max = 1;
        for (int i=0; i<M; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    private int lengthStartingHere(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        Position curr = new Position(i, j);
        int max = 0;
        for (Position neighbour : curr.neighbours(matrix.length, matrix[0].length)) {
            if (matrix[neighbour.i][neighbour.j] > matrix[i][j]) {
                max = Math.max(max, lengthStartingHere(matrix, neighbour.i, neighbour.j, dp));
            }
        }
        dp[i][j] = 1+Math.max(0, max);
        return dp[i][j];
    }

    class Position {
        int i, j;
        int[][] offsets = {{0,-1}, {0,1}, {-1,0},{1,0}};
        public Position(int x, int y) {
            i=x;
            j=y;
        }

        public boolean isValid(int M, int N) {
            return i>=0 && i<M && j>=0 && j<N;
        }
        public List<Position> neighbours(int M, int N) {
            List<Position> list= new ArrayList<>();
            for (int[] offset : offsets) {
                Position neighbour = new Position(i+offset[0], j+offset[1]);
                if (neighbour.isValid(M, N)) {
                    list.add(neighbour);
                }
            }
            return list;
        }
    }
}