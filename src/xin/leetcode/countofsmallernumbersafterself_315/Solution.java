package xin.leetcode.countofsmallernumbersafterself_315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Xin on 9/16/2016.
 */
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        BST tree = new BST();
        for (int i=nums.length-1; i>=0; i--) {
            int count = tree.insert(nums[i]);
            list.add(0, count);
        }
        return list;
    }
}