package xin.leetcode.linereflection_356;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by Xin on 9/7/2016.
 */
public class Solution {
    public boolean isReflected(int[][] points) {
        if (points.length == 0 || points.length == 1) {
            return true;
        }
        int max = points[0][0], min = points[0][0];
        HashSet<String> set = new HashSet<>();

        for (int[] point : points) {
            max=  Math.max(max, point[0]);
            min = Math.min(min, point[0]);

            set.add(point[0] + "," + point[1]);
        }

        int mid2 = max + min;
        for (int[] point:points) {
            if (!set.contains( (mid2 - point[0]) + "," + point[1])) {
                return false;
            }
        }
        return true;
    }
//    public boolean isReflected(int[][] points) {
//        if (points.length == 0 || points.length == 1) {
//            return true;
//        }
//        Comparator<int[]> comp = ((a, b) -> a[0] - b[0]);
//        Arrays.sort(points, comp);
//
//        int length = points.length;
//        int left, right;
//
//        double mid_value;
//        if (length %2 == 0) {
//            mid_value = (points[length/2][0] + points[length/2-1][0]) / 2.0;
//            right = length/2;
//            left = right - 1;
//        } else {
//            mid_value = points[length/2][0];
//            left = length/2- 1;
//            right = length/2 + 1;
//        }
//
//        System.out.println("mid line: " + mid_value);
//
//        while (left >=0 && right <= length-1) {
//            if (!helper(points[left], points[right], mid_value)) {
//                return false;
//            }
//            left --;
//            right++;
//        }
//        return true;
//    }
//
//    private boolean helper(int p1[], int p2[], double line) {
//        return p1[1] == p2[1] &&
//                (line -  p1[0] == p2[0] - line);
//    }

}