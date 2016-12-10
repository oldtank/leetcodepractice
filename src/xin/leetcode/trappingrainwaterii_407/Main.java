package xin.leetcode.trappingrainwaterii_407;

/**
 * Created by Xin on 9/29/2016.
 */
public class Main {
    public static void main(String[] args) {
        int map[][] = {
        {1,4,3,1,3,2},
        {3,2,1,3,2,4},
        {2,3,3,2,3,1}
        };

        System.out.println(new Solution().trapRainWater(map));
    }
}
