package xin.leetcode.trappingrainwater_42;

/**
 * Created by Xin on 9/8/2016.
 */
public class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int water = 0;
        int leftBorder = 0, leftHeight = height[leftBorder];
        int rightBorder = height.length - 1, rightHeight = height[rightBorder];
        while(rightBorder - leftBorder >=2 ) {
            if (leftHeight < rightHeight) {
                water += Math.max(0, leftHeight - height[leftBorder+1]);
//                System.out.println("water: " + water);
                leftHeight = Math.max(leftHeight, height[leftBorder+1]);
                leftBorder++;
            } else {
                water += Math.max(0, rightHeight - height[rightBorder-1]);
//                System.out.println("water: " + water);
                rightHeight = Math.max(rightHeight, height[rightBorder-1]);
                rightBorder--;
            }
        }
        return water;
    }

    public int trap1(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int lefts[] = getLefts(height);
        int rights[] = getRights(height);
        int total = 0;
        for (int i=1; i<height.length-1; i++) {
            total += Math.max(0, Math.min(lefts[i],rights[i]) - height[i]);
        }
        return total;
    }

    private int[] getRights(int[] height) {
        int rights[] = new int[height.length];
        rights[height.length-1] = -1;
        for (int i=height.length-2; i>=0; i--) {
            rights[i] = Math.max(height[i+1], rights[i+1]);
        }
        return rights;
    }

    private int[] getLefts(int[] height) {
        int lefts[] = new int[height.length];
        lefts[0] = -1;
        for (int i=1; i<height.length; i++) {
            lefts[i] = Math.max(height[i-1], lefts[i-1]);
        }
        return lefts;
    }
}