package xin.leetcode.graphvalidtree_261;

/**
 * Created by Xin on 9/6/2016.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n=4;
//        int edges[][] = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
//        int edges[][] = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        int edges[][] = {{2,3},{1,2},{1,3}};
        System.out.println(solution.validTree(n, edges));
    }
}
