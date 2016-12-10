package xin.leetcode.wallsandgates_286;

import java.util.*;

/**
 * Created by Xin on 9/2/2016.
 */
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length ==0 || rooms[0].length == 0) {
            return;
        }
        Queue<Position> queue=  new ArrayDeque<>();
        int m = rooms.length, n=rooms[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i=0; i<rooms.length; i++) {
            for (int j = 0; j<rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Position(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Position curr = queue.poll();
            for (Position neighbour : curr.neighbours()) {
                if ( neighbour.isValid(m, n) && rooms[neighbour.i][neighbour.j] != -1 && !visited[neighbour.i][neighbour.j]) {
                    rooms[neighbour.i][neighbour.j] = Math.min(rooms[neighbour.i][neighbour.j], rooms[curr.i][curr.j]+1);
                    visited[neighbour.i][neighbour.j] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return;
    }

    public class Position {
        int i;
        int j;
        public Position(int i, int j) {
            this.i =i;
            this.j = j;
        }

        public List<Position> neighbours() {
            List<Position> neighbours = new ArrayList<>();
            neighbours.add(left());
            neighbours.add(right());
            neighbours.add(top());
            neighbours.add(bottom());

            return neighbours;
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

        public boolean isValid(int m, int n) {
            return i<m && i>=0 && j <n && j>=0;
        }
    }
}