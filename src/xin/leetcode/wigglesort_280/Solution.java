package xin.leetcode.wigglesort_280;

import java.util.Arrays;

/**
 * Created by Xin on 9/28/2016.
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int test[] = {3,4,1,8,5,9};

        int from = 0, to=test.length-1;
        int pivot = partition(test,from,to);
        System.out.println(pivot);
        for(int i : test) {
            System.out.print(i + " ");
        }
        System.out.println();
        int median_pos = to/2;
        while (pivot != median_pos) {
            if (pivot < median_pos) {
                from = pivot+1;
                pivot = partition(test, from, to);

            } else {
                to = pivot-1;
                pivot = partition(test, from, to);
//                System.out.println("pivot: " + pivot);
            }
        }
        System.out.println(pivot);
        for(int i : test) {
            System.out.print(i + " ");
        }
    }

    private int partition(int[] nums, int from, int to) {
        System.out.println("from: " + from + ", to: " + to);
        int pivot = to;
        int i=from;
        int j=from-1;
        while (i < pivot) {
            if (nums[i] <= nums[pivot]) {
                swap(nums, j+1, i);
                j++;
            }
            i++;
        }
        swap(nums, j+1, pivot);
        return j+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}