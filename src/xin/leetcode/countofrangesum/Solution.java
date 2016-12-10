package xin.leetcode.countofrangesum;

/**
 * Created by Xin on 9/18/2016.
 */
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sums[] = new int[nums.length+1];
        for (int i=1; i<=nums.length; i++) {
            sums[i] = sums[i-1]+nums[i-1];
        }
        int count = 0;
        BST tree = new BST();
        tree.insert(sums[0]);
        for (int i=1; i<sums.length; i++) {
            count += tree.rangeSize(tree.root, sums[i]-upper, sums[i]-lower);
            tree.insert(sums[i]);
        }
        return count;
    }
}