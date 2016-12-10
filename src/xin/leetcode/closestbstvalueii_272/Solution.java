package xin.leetcode.closestbstvalueii_272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Xin on 9/19/2016.
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> sorted = new ArrayList<>();
//        getSorted(root, sorted);
        Integer sorted_a[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49};
        sorted = Arrays.asList(sorted_a);

        if (sorted.size() < k) {
            return new ArrayList<>();
        }
        if (sorted.size() ==k) {
            return sorted;
        }
        int floor_index = getFloor(sorted, 0, sorted.size()-1, target);
        int ceiling_index = floor_index+1;

        List<Integer> result = new LinkedList<>();
        int i=floor_index, j=ceiling_index;
        while (i>=0 && j<sorted.size() && result.size() < k) {
            if (target-sorted.get(i) < (double) sorted.get(j)-target) {
                result.add(0, sorted.get(i));
                i--;
            } else {
                result.add(sorted.get(j));
                j++;
            }
        }
        if (result.size() < k) {
            int extra = k-result.size();
            if (i < 0) {
                for (int t = 0; t< extra; t++) {
                    result.add(sorted.get(j++));
                }
            } else {
                for (int t = 0; t< extra; t++) {
                    result.add(0, sorted.get(i--));
                }
            }
        }
        return result;
    }

    public int getFloor(List<Integer> list, int left, int right, double target) {
        System.out.println("checking between: " + list.get(left) + " "+list.get(right));
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        int mid = (left+right)/2;
        System.out.println("mid: "+list.get(mid));
        if (list.get(mid) == target) {
            return mid;
        } else if (list.get(mid) > target) {
            return getFloor(list, left, mid-1, target);
        } else {
            if (mid == left) {
                if (list.get(right) < target) {
                    return right;
                } else {
                    return left;
                }
            } else {
                return getFloor(list, mid, right, target);
            }
        }
    }

    public void getSorted(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        getSorted(root.left, list);
        list.add(root.val);
        getSorted(root.right, list);
    }
}