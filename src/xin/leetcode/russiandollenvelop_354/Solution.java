package xin.leetcode.russiandollenvelop_354;

import java.util.Arrays;

/**
 * Created by Xin on 9/20/2016.
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length==0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> (a[0] - b[0]));
        int max = 1;
        int lengthEndingHere[] = new int[envelopes.length];
        for (int i=0; i<lengthEndingHere.length; i++) {
            lengthEndingHere[i] = 1;
        }

        for (int i=1; i<lengthEndingHere.length; i++) {
            int curr_length = 1;
            for (int j=0; j<i; j++) {
                if (envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) {
                    curr_length = Math.max(curr_length, lengthEndingHere[j]+1);
                }
            }
            max = Math.max(max, curr_length);
            lengthEndingHere[i] = curr_length;
        }
        return max;
    }
}