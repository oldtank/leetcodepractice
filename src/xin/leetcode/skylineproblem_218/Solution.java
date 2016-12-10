package xin.leetcode.skylineproblem_218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xin on 11/27/2016.
 */
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        Arrays.sort(buildings, (a, b) -> (a[0] - b[0]));
        int N = -1;
        for (int i=0; i<buildings.length; i++) {
            N = Math.max(buildings[i][1], N);
        }
        List<int[]> skyline = helper(buildings, 0, buildings.length-1, N);
        return skyline;
    }

    private List<int[]> helper(int[][] buildings, int left, int right, int N) {
        if (right < left) {
            return null;
        }
        List<int[]> result = new ArrayList<>();
        if (right == left) {
            result.add(new int[]{buildings[left][0], buildings[left][2]});
            result.add(new int[]{buildings[left][1], 0});
            return result;
        }
        int mid = left + (right - left) /2;
        List<int[]> lefts = helper(buildings, left, mid, N);
        List<int[]> rights = helper(buildings, mid+1, right, N);
        return merge(lefts, rights);
    }

    private List<int[]> merge(List<int[]> l1, List<int[]> l2) {
        if (l1 == null || l2 == null) {
            return l1==null ? l2 : l1;
        }

        int lastH1 = -1, lastH2 = -1;
        List<int[]> merged = new ArrayList<>();
        for (int i=0, j=0; i<l1.size() || j<l2.size();) {
            if (i==l1.size()) {
                merged.add(l2.get(j));
                j++;
            } else if (j == l2.size()) {
                merged.add(l1.get(i));
                i++;
            } else {
                int[] node1 = l1.get(i);
                int[] node2 = l2.get(j);
                if (node1[0] < node2[0]) {
                    if (node1[1] > lastH2) {
                        merged.add(new int[]{node1[0], node1[1]});
                        lastH1 = node1[1];
                    } else {
                        merged.add(new int[]{node1[0], lastH2});
                    }
                    i++;
                } else if (node2[0] < node1[0]) {
                    if (node2[1] > lastH1) {
                        merged.add(new int[]{node2[0], node2[1]});
                        lastH2 = node2[1];
                    } else {
                        merged.add(new int[]{node2[0], lastH1});
                    }
                    j++;
                } else {
                    merged.add(new int[]{node1[0], Math.max(node1[1], node2[1])});
                    lastH1 = node1[1];
                    lastH2 = node2[1];
                    i++;
                    j++;
                }
            }
        }
        return merged;
    }


}