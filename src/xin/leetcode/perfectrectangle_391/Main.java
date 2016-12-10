package xin.leetcode.perfectrectangle_391;

/**
 * Created by Xin on 9/25/2016.
 */
public class Main {
    public static void main(String[] args) {
        int rectangles[][] = {{1,1,3,3},
        {3,1,4,2},
        {1,3,2,4},
        {2,2,4,4}};

        System.out.println(new Solution().isRectangleCover(rectangles));
    }
}
