package xin.leetcode.perfectrectangle_391;

/**
 * Created by Xin on 9/24/2016.
 */
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0) {
            return true;
        }

        int left = rectangles[0][0];
        int right = rectangles[0][2];
        int top = rectangles[0][3];
        int bottom = rectangles[0][1];
        int area = (rectangles[0][2] - rectangles[0][0]) * (rectangles[0][3] - rectangles[0][1]);

        for (int i=1; i<rectangles.length; i++) {
            for (int j=0; j<i; j++) {
                if (intersect(rectangles[j], rectangles[i])) {
                    return false;
                }
            }
            area += (rectangles[i][2] - rectangles[i][0])*(rectangles[i][3] - rectangles[i][1]);
            left = Math.min(left, rectangles[i][0]);
            right = Math.max(right, rectangles[i][2]);
            top=  Math.max(top, rectangles[i][3]);
            bottom = Math.min(bottom, rectangles[i][1]);
        }

        System.out.println(area);
        System.out.println("left: " + left);
        System.out.println("right: " + right);
        System.out.println("top: " + top);
        System.out.println("bottom: " + bottom );
        return area == (right-left)*(top-bottom);
    }

    public boolean intersect(int[] rect1, int[] rect2) {
        int twicecenter1[] = {(rect1[0] + rect1[2]), (rect1[1] + rect1[3])};
        int twicecenter2[] = {(rect2[0] + rect2[2]), (rect2[1] + rect2[3])};

        return Math.abs(twicecenter1[0] - twicecenter2[0]) < Math.abs(rect1[0] - rect1[2])+Math.abs(rect2[0] - rect2[2]) &&
                Math.abs(twicecenter1[1] - twicecenter2[1]) < Math.abs(rect1[1] - rect1[3]) + Math.abs(rect2[1] - rect2[3]);
    }


}