package xin.leetcode.wigglesortii_324;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

 Note:
 You may assume all input has valid answer.

 Follow Up:
 Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int median = findKth(nums, 0, nums.length-1, (nums.length-1)/2);
        if (median >0) {
            arrangeFront(nums, 0, median-1, nums[median]);
        }
        if (median < nums.length-1) {
            arrangeEnd(nums, median+1, nums.length-1, nums[median]);
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println(median);
        int ans[] = new int[nums.length];

        int left = median, right = nums.length-1;
        for (int i=0; i<ans.length; i++) {
            ans[i] = (i%2==0) ? nums[left--] : nums[right--];
        }
        for (int i=0; i<ans.length; i++) {
            nums[i] = ans[i];
        }
        Arrays.stream(nums).forEach(n -> System.out.print(n + " "));
    }

    void arrangeFront(int[] nums, int i, int j, int key) {
        while (i < j) {
            if (nums[i] == key && nums[j] != key) {
                swap(nums, i, j);
                i++;
                j--;
            } else if (nums[i] != key) {
                i++;
            } else {
                j--;
            }
        }
    }

    void arrangeEnd(int[] nums, int i, int j, int key) {
        while (i < j) {
            if (nums[i] != key && nums[j] == key) {
                swap(nums, i, j);
                i++;
                j--;
            } else if (nums[i] == key) {
                i++;
            } else {
                j--;
            }
        }
    }

    public int findKth(int[] nums, int l, int r, int k) {
        int p = partition(nums, l, r);
        if (p== k) {
            return p;
        } else if (p<k) {
            return findKth(nums, p+1, r, k);
        } else {
            return findKth(nums, l, p-1, k);
        }
    }

    public int partition(int[] nums, int l, int r) {
        if (l==r) {
            return l;
        }
        int i=l-1, j=l;
        while (j < r) {
            if (nums[j] <= nums[r]) {
                swap(nums, i+1, j);
                i++;
            }
            j++;
        }
        swap(nums, i+1, r);
        return i+1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
