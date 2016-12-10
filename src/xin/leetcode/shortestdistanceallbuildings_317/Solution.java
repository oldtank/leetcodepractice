package xin.leetcode.shortestdistanceallbuildings_317;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Xin on 9/17/2016.
 */
public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0]==null || grid[0].length==0) {
            return -1;
        }
        int m=grid.length;
        int n=grid[0].length;
        int buildingsFound = 0;
        Record records[][] = new Record[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n;j++) {
                records[i][j] = new Record();
            }
        }

        int offsets[][] = {{0,-1},{0,1},{-1,0},{1,0}};

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                boolean visited[][]= new boolean[m][n];
                visited[i][j] = true;
                records[i][j].distance = 0;
                Queue<Position> queue = new ArrayDeque<>();
                queue.offer(new Position(i, j, 0));
                while (!queue.isEmpty()) {
                    Position curr = queue.poll();
                    for (int[] offset : offsets) {
                        Position pos = new Position(curr.i + offset[0], curr.j + offset[1], curr.distance+1);
                        if (pos.isValid(m, n) && !visited[pos.i][pos.j] && grid[pos.i][pos.j] == 0
                                && records[pos.i][pos.j].count == buildingsFound) {
                            visited[pos.i][pos.j] = true;
                            records[pos.i][pos.j].count = buildingsFound + 1;
                            if (records[pos.i][pos.j].distance == Integer.MAX_VALUE) {
                                records[pos.i][pos.j].distance = pos.distance;
                            } else {
                                records[pos.i][pos.j].distance += pos.distance;
                            }
                            queue.offer(pos);
                        }
                    }
                }

//                for (int u=0; u<m; u++){
//                    for (int v=0; v<n; v++) {
//                        System.out.print((records[u][v].distance == Integer.MAX_VALUE ? -1 : records[u][v].distance) +" ");
//                    }
//                    System.out.println();
//                }

                buildingsFound++;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (records[i][j].count == buildingsFound) {
                    min = Math.min(min, records[i][j].distance);
                }
            }
        }

        return (min == Integer.MAX_VALUE ? -1 : min);
    }

    class Record {
        int distance;
        int count;

        public Record() {
            distance = Integer.MAX_VALUE;
            count = 0;
        }
    }

    class Position {
        int i;
        int j;
        int distance;
        public Position(int x, int y, int d) {
            i=x;
            j=y;
            distance = d;
        }

        public boolean isValid(int m, int n) {
            return i>=0 && i<m && j>=0 && j<n;
        }
    }
}
