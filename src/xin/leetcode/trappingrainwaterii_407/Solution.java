package xin.leetcode.trappingrainwaterii_407;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Xin on 9/29/2016.
 */
public class Solution {
    class Cell {
        int i;
        int j;
        int height;

        public Cell(int x, int y, int h) {
            i=x;
            j=y;
            height = h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int M = heightMap.length;
        int N = heightMap[0].length;
        PriorityQueue<Cell> boundary = new PriorityQueue<>((a, b) -> (a.height-b.height));
        boolean visited[][] = new boolean[M][N];

        for (int j=0; j<N; j++) {
            boundary.offer(new Cell(0, j, heightMap[0][j]));
            visited[0][j] = true;
            boundary.offer(new Cell(M-1, j, heightMap[M-1][j]));
            visited[M-1][j] = true;
        }

        for (int i=1; i<M-1; i++) {
            boundary.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            boundary.offer(new Cell(i, N-1, heightMap[i][N-1]));
            visited[i][N-1] = true;
        }

        int neighbours[][] = {{0,-1},{0,1},{-1,0},{1,0}};
        int water = 0;
        while (!boundary.isEmpty()) {
            Cell lowest = boundary.poll();
            for (int[] neighbour : neighbours) {
                int ni = neighbour[0]+lowest.i;
                int nj = neighbour[1] + lowest.j;

                if (ni>=0 && ni<M && nj>=0 && nj<N && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    water += Math.max(0, lowest.height - heightMap[ni][nj]);
                    boundary.offer(new Cell(ni, nj, Math.max(lowest.height, heightMap[ni][nj])));
                }
            }
        }
        return water;
    }
}