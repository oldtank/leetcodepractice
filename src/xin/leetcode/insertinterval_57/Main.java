package xin.leetcode.insertinterval_57;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/17/2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,1));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(9,9));
        intervals.add(new Interval(12,16));

        Interval newInerval = new Interval(4, 9);
        List<Interval> merged = new Solution().insert(intervals, newInerval);

        merged.forEach(interval -> System.out.print("("+interval.start+","+interval.end+")"));

    }
}
