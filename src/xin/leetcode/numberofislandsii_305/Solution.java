package xin.leetcode.numberofislandsii_305;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/16/2016.
 */
public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> list = new ArrayList<>();
        if (positions.length ==0 || positions[0].length == 0) {
            return list;
        }

        int offsets[][] = {{0,-1},{0,1},{-1,0},{1,0}};

        UnionFind uf = new UnionFind(m, n);
        for (int i=0; i<positions.length; i++) {
            int index = uf.index(positions[i][0], positions[i][1]);
            uf.add(index);

            for (int[] pos: offsets) {
                int x = positions[i][0] + pos[0];
                int y = positions[i][1] + pos[1];
                if (isValid(x, y, m, n) && uf.alreadyAdded(x, y)) {
                    uf.union(index, uf.index(x, y));
                }
            }
            list.add(uf.count);
        }
        return list;
    }

    public static boolean isValid(int x, int y, int M, int N) {
        return x >=0 & x <M && y>=0 && y<N;
    }
}