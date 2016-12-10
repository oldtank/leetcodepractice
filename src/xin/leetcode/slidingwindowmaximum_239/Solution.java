package xin.leetcode.slidingwindowmaximum_239;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Xin on 9/9/2016.
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length==0) {
            return new int[0];
        }
        int n = nums.length;
        int max[] = new int[n-k+1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i=0; i<k; i++) {
            addToQueue(queue, nums[i]);
        }
        max[0] = queue.peek();
//        System.out.println("adding " +max[0]);
        for (int i=1; i<=n-k; i++) {
            int new_num = nums[i+k-1];
            if (queue.peek() == nums[i-1]) {
                queue.removeFirst();
            }
            addToQueue(queue, new_num);
            max[i] = queue.peek();
//            System.out.println("adding " +max[i]);
        }
        return max;
    }

    public void addToQueue(ArrayDeque<Integer> queue, int x) {
        while (!queue.isEmpty()) {
            if(x> queue.peekLast()) {
                queue.removeLast();
            } else {
                break;
            }
        }
        queue.addLast(x);
    }
}