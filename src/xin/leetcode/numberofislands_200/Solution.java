package xin.leetcode.numberofislands_200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Xin on 8/30/2016.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    travelOneIsland(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void travelOneIsland(char[][] grid, int i, int j, boolean[][] visited) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<Position> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.offer(new Position(i, j));

        while(!queue.isEmpty()) {
            Position curr = queue.poll();
            for (Position reachable : curr.reachablePositions(M, N)) {
                if (!visited[reachable.i][reachable.j] && grid[reachable.i][reachable.j] == '1') {
                    visited[reachable.i][reachable.j] = true;
                    queue.offer(reachable);
                }
            }
        }
    }

    class Position {
        int i;
        int j;
        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Position left() {
            return new Position(i, j-1);
        }

        public Position right() {
            return new Position(i, j+1);
        }

        public Position top() {
            return new Position(i-1, j);
        }

        public Position bottom() {
            return new Position(i+1, j);
        }

        public List<Position> reachablePositions(int M, int N) {
            List<Position> list = new ArrayList<>();
            if (left().isValid(M, N)) {
                list.add(left());
            }
            if (right().isValid(M, N)) {
                list.add(right());
            }
            if (top().isValid(M, N)) {
                list.add(top());
            }
            if (bottom().isValid(M, N) ) {
                list.add(bottom());
            }
            return list;
        }

        public boolean isValid(int M, int N) {
            return i < M && i>=0 && j < N && j>=0;
        }
    }
}