package xin.leetcode.bombenemy_361;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/3/2016.
 */
public class Solution {

    public class EnemyCount {
        int top;
        int bottom;
        int left;
        int right;
        public EnemyCount() {
        }
    }

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int[][] offset = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int M = grid.length, N=  grid[0].length;
        int max = 0;
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (grid[i][j] == '0') {
                    System.out.println("Starting to check bomb position " + i +", " +j);
                    int count = 0;
                    for (int x=0; x<offset.length; x++) {
                        int next_i = i+offset[x][0];
                        int next_j = j+offset[x][1];
                        while (new Position(next_i, next_j, M, N).isValid() && grid[next_i][next_j] != 'W') {
                            System.out.println("checking position "+next_i+", "+next_j);
                            if (grid[next_i][next_j] == 'E') {
                                count++;
                            }
                            next_i = next_i+offset[x][0];
                            next_j = next_j+offset[x][1];
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    public class Position {
        int i;
        int j;
        int M;
        int N;

        public Position(int i, int j, int M, int N) {
            this.i=i;
            this.j=j;
            this.M=M;
            this.N=N;
        }

        public boolean isValid() {
            return i>=0 && i<M && j>=0 && j<N;
        }
    }
}