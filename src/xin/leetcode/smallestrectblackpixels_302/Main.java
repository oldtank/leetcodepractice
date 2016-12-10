package xin.leetcode.smallestrectblackpixels_302;

/**
 * Created by Xin on 9/19/2016.
 */
public class Main {
    public static void main(String[] args) {
        char image[][] = {{'0','0','1','0'},
                {'0','1','1','0'},
                {'0','1','0','0'}};
        int x=0, y=2;

        System.out.println(new Solution().minArea(image, x, y));
    }
}
