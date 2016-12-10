package xin.leetcode.sorttransformedarray_360;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Xin on 10/2/2016.
 */
public class Solution {
    class NumAndDistance {
        int val;
        double distance;

        public NumAndDistance(int v, double d) {
            val = v;
            distance = d;
        }
    }
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] rearranged = new int[nums.length];
        if (a==0) {
            if (b >= 0) {
                for (int i=0; i<nums.length; i++) {
                    rearranged[i] = b * nums[i] + c;
                }
            } else {
                for (int i=0; i<nums.length; i++) {
                    rearranged[i] = b * nums[nums.length -1 - i] + c;
                }
            }
            return rearranged;
        }
        Comparator<NumAndDistance> comp;
        if (a>0) {
            comp = (x, y) -> {
                if (x.distance < y.distance) {
                    return -1;
                } else if (x.distance > y.distance) {
                    return 1;
                } else {
                    return 0;
                }
            };
        } else {
            comp = (x, y) -> {
                if (x.distance > y.distance) {
                    return -1;
                } else if (x.distance < y.distance) {
                    return 1;
                } else {
                    return 0;
                }
            };
        }

        PriorityQueue<NumAndDistance> pq = new PriorityQueue<>(comp);
        double peak = -1D * b / 2D / a;
        for (int i=0; i<nums.length; i++) {
            pq.offer(new NumAndDistance(nums[i], Math.abs(peak - nums[i])));
        }

        int i=0;
        while (!pq.isEmpty()) {
            int x = pq.poll().val;
            System.out.println(x);
            rearranged[i] = a * x * x + b * x + c;
            i++;
        }

        return rearranged;
    }
}