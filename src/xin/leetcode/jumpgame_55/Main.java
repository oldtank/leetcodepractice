package xin.leetcode.jumpgame_55;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.jar.Pack200;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.

 https://leetcode.com/problems/jump-game/
 */
public class Main {
    public static void main(String[] args) {
        int nums[] = {3,2,1,0,4};
        System.out.println(canJump2(nums));
    }
    public static boolean canJump(int[] nums) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean reachable[] = new boolean[nums.length];
        queue.push(nums.length-1);
        reachable[nums.length-1] = true;
        while (!queue.isEmpty()) {
            int curr_pos = queue.pop();
            for (int i=0; i<nums.length; i++) {
                if (i == curr_pos) {
                    continue;
                }
                if (!reachable[i] && curr_pos-i <= nums[i]) {
                    reachable[i] = true;
                    queue.push(i);
                }
            }
        }
        return reachable[0];
    }

    public static boolean canJump2(int nums[]) {
        if (nums.length==0 || nums.length==1) {
            return true;
        }
        boolean visited[] = new boolean[nums.length];
        visited[nums.length-1] = true;
        return canJump2(nums, nums.length-1, visited);
    }

    public static boolean canJump2(int nums[], int start, boolean[] visited) {
        for (int i=0; i<nums.length; i++) {
            if (!visited[i] && (Math.abs(i-start)) <= nums[i]) {
                if (i==0) {
                    return true;
                } else {
                    visited[i] = true;
                    if (canJump2(nums, i, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean canJump3(int nums[]) {
        int left_most = nums.length-1;
        for (int i=nums.length-1; i>=0; i++) {
            if (i+nums[i] >= left_most) {
                left_most = i;
            }
        }
        return left_most == 0;
    }
}
