package xin.leetcode.rangesumquery2dmutable_308;

import java.util.TreeSet;

/**
 * Created by Xin on 10/1/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}
        };
        NumMatrix m = new NumMatrix(matrix);
        System.out.println(m.sumRegion(2,1,4,3));

        m.update(4,2,10);
        System.out.println(m.sumRegion(2,1,4,3));
    }
}
