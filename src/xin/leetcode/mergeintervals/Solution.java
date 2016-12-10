package xin.leetcode.mergeintervals;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Xin on 9/7/2016.
 */
public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0 || intervals.size()==1) {
            return intervals;
        }
        Comparator<Interval> cmp = (inv1, inv2) -> (inv1.start - inv2.start);
        Collections.sort(intervals, cmp);
        for (int i=1; i<intervals.size(); i++) {
            if (intervals.get(i).start <= intervals.get(i-1).end) {
                intervals.get(i-1).end = Math.max(intervals.get(i).end, intervals.get(i-1).end);
                intervals.remove(i);
                i--;
            }
        }
        return intervals;
    }
}