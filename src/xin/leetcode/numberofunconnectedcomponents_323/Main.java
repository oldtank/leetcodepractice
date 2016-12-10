package xin.leetcode.numberofunconnectedcomponents_323;

/**
 * Created by Xin on 9/5/2016.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int edges[][] = {{5,6},{0,2},{1,7},{5,9},{1,8},{3,4},{0,6},{0,7},{0,3},{8,9}};
        int n=10;
        System.out.println(solution.countComponents(n, edges));
    }
}
