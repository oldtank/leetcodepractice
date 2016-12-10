package xin.leetcode.wallsandgates_286;

/**
 * Created by Xin on 9/2/2016.
 */
public class Main {
    public static void main(String[] args) {
        int rooms[][] ={{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        Solution solution = new Solution();
        solution.wallsAndGates(rooms);
    }
}
