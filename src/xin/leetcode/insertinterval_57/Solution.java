package xin.leetcode.insertinterval_57;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/17/2016.
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();
        Interval array[] = new Interval[intervals.size()];
        intervals.toArray(array);

        int floorStart = findFloorStart(array, 0, array.length-1, newInterval.start);
        int ceilingEnd = findCeilingEnd(array, 0, array.length-1, newInterval.end);

        if (floorStart < 0) {
            if (ceilingEnd < 0) {
                list.add(newInterval);
            } else {
                if (newInterval.end < array[ceilingEnd].start) {
                    list.add(newInterval);
                    list.add(array[ceilingEnd]);
                } else {
                    list.add(new Interval(newInterval.start, array[ceilingEnd].end));
                }
                for (int i=ceilingEnd +1; i<array.length; i++) {
                    list.add(array[i]);
                }
            }
        } else {
            for (int i=0; i<=floorStart-1; i++) {
                list.add(array[i]);
            }
            int s;
            if (newInterval.start > array[floorStart].end) {
                list.add(array[floorStart]);
                s=newInterval.start;
            } else {
                s=array[floorStart].start;
            }
            if (ceilingEnd < 0) {
                list.add(new Interval(s, newInterval.end));
            } else {
                if (newInterval.end < array[ceilingEnd].start) {
                    list.add(new Interval(s, newInterval.end));
                    list.add(array[ceilingEnd]);
                } else {
                    list.add(new Interval(s, array[ceilingEnd].end));
                }
                for (int i=ceilingEnd +1; i<array.length; i++) {
                    list.add(array[i]);
                }
            }
        }
        return list;
    }

    public int findFloorStart(Interval[] intervals, int left, int right, int key) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            if (intervals[left].start <= key) {
                return left;
            } else {
                return -1;
            }
        }
        int mid = (left+right)/2;
        if (intervals[mid].start == key) {
            return mid;
        } else if (intervals[mid].start > key) {
            return findFloorStart(intervals, left, mid-1, key);
        } else {
            if (intervals[mid+1].start > key) {
                return mid;
            } else {
                return findFloorStart(intervals, mid+1, right, key);
            }
        }
    }

    public int findCeilingEnd(Interval[] intervals, int left, int right, int key) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            if (intervals[left].end >= key) {
                return left;
            } else {
                return -1;
            }
        }
        int mid = (left+right)/2;
        if (intervals[mid].end == key) {
            return mid;
        } else if (intervals[mid].end > key) {
            if (left == mid) {
                return mid;
            } else {
                return findCeilingEnd(intervals, left, mid, key);
            }
        } else {
            return findCeilingEnd(intervals, mid+1, right, key);
        }
    }
}