package xin.leetcode.numberofislandsii_305;

/**
 * Created by Xin on 9/16/2016.
 */
public class Main {
    public static void main(String[] args) {
        int m=3;
        int n=3;
        int positions[][] = {{0,0}, {0,1}, {1,2}, {2,1}, {1,1}};
        System.out.println(new Solution().numIslands2(m, n, positions));
    }
}
