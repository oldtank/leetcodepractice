package xin.leetcode.hindex_274;

import java.util.Arrays;

/**
 * Created by Xin on 9/1/2016.
 */
public class Solution {
    public int hIndex(int[] citations) {
        int count[] = new int[citations.length+1];
        for (int i=0; i<citations.length; i++) {
            count[Math.min(citations[i], citations.length)]++;
        }

        for (int i=count.length-2; i>=0; i--) {
            count[i] += count[i+1];
        }
        int i=citations.length;
        for (; i>=0; i--) {
            if (count[i] >= i) {
                return i;
            }
        }
        return 0;
    }
}