package xin.leetcode.kthsmallest_378;

/**
 * Created by Xin on 9/1/2016.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int matrix[][] = {{1,3,5},{6,7,12},{11,14,14}};
        System.out.println(solution.kthSmallest(matrix, 3));
    }
}
