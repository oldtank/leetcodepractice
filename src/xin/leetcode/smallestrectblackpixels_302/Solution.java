package xin.leetcode.smallestrectblackpixels_302;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Xin on 9/19/2016.
 */
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
            return 0;
        }
        Border border = new Border();

        int M = image.length;
        int N = image[0].length;
        boolean visited[][] = new boolean[M][N];
        Queue<Position> queue = new ArrayDeque<>();

        visited[x][y] = true;
        Position curr = new Position(x, y);
        queue.offer(curr);
        border.update(curr);

        while (!queue.isEmpty()) {
            curr = queue.poll();
            border.update(curr);

            List<Position> neighbours = curr.neighbours(M, N);
            for(Position neighbour: neighbours) {
                if (image[neighbour.i][neighbour.j] == '1' && !visited[neighbour.i][neighbour.j]) {
                    visited[neighbour.i][neighbour.j] = true;
                    queue.offer(neighbour);
                }
            }
        }

        return (border.max_bottom-border.min_top+1)*(border.max_right-border.min_left+1);
    }

    class Border {
        int min_left;
        int min_top;
        int max_right;
        int max_bottom;

        public Border() {
            min_left = Integer.MAX_VALUE;
            min_top = Integer.MAX_VALUE;
            max_right = Integer.MIN_VALUE;
            max_bottom = Integer.MIN_VALUE;
        }

        public void update(Position x) {
            min_top = Math.min(min_top, x.i);
            min_left = Math.min(min_left, x.j);
            max_right = Math.max(max_right, x.j);
            max_bottom = Math.max(max_bottom, x.i);
        }
    }

    class Position {
        int i;
        int j;
        int offsets[][]={{0,-1},{0,1},{-1,0}, {1,0}};
        public Position(int x, int y) {
            i=x;
            j=y;
        }
        public boolean isValid(int M, int N) {
            return i>=0 && i <M && j>=0 && j<N;
        }
        public List<Position> neighbours(int M, int N) {
            List<Position> list = new ArrayList<>();
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