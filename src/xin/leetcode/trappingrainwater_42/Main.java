package xin.leetcode.trappingrainwater_42;

/**
 * Created by Xin on 9/8/2016.
 */
public class Main {
    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution solution = new Solution();
        System.out.println(solution.trap(height));
        System.out.println(solution.trap1(height));
    }
}
