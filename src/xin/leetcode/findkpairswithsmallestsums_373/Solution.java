package xin.leetcode.findkpairswithsmallestsums_373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Xin on 9/4/2016.
 */
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int suma = nums1[a[0]]+nums2[a[1]];
                int sumb = nums1[b[0]]+nums2[b[1]];
                return suma - sumb;
            }
        };
        PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);

        for (int i=0; i<nums1.length; i++) {
            queue.offer(new int[]{i, 0});
        }

        List<int[]> list = new ArrayList<>();
        while(!queue.isEmpty() && list.size() <k) {
            int[] indices = queue.poll();
            list.add(new int[]{nums1[indices[0]], nums2[indices[1]]});
            indices[1]++;
            if (indices[1] < nums2.length) {
                queue.offer(indices);
            }
        }
        return list;
    }
}