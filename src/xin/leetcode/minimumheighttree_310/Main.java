package xin.leetcode.minimumheighttree_310;

/**
 * Created by Xin on 9/7/2016.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n=6;
        int edges[][] = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(solution.findMHT(n, edges));



    }
}
