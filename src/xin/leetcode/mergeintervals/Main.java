package xin.leetcode.mergeintervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/7/2016.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));

        solution.merge(list);
        print(list);
    }

    public static void print(List<Interval> list) {
        list.forEach(interval -> {
            System.out.print("("+interval.start + ", "+interval.end+") " );
        });
        System.out.println();
    }
}
