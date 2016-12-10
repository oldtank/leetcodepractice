package xin.leetcode.skylineproblem_218;

import java.util.List;

/**
 * Created by Xin on 11/27/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}};
        List<int[]> skyline = new Solution().getSkyline(buildings);
        for (int i=0; i<skyline.size(); i++) {
            System.out.print("["+skyline.get(i)[0] + " " + skyline.get(i)[1] + "], ");
        }
    }
}
