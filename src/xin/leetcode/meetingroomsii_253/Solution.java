package xin.leetcode.meetingroomsii_253;

import java.util.*;

/**
 * Created by Xin on 9/2/2016.
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));

        //priority queue of already arranged intervals based on end time
        PriorityQueue<Interval> pq = new PriorityQueue<>( (a, b) -> (a.end - b.end));

        int count = 1;
        pq.offer(intervals[0]);
        for (int i=1; i<intervals.length; i++) {
            Interval endingEarliest = pq.peek();
            if (intervals[i].start < endingEarliest.end) {
                count++;
                pq.offer(intervals[i]);
            } else {
                pq.poll();
                pq.offer(intervals[i]);
            }
        }
        return count;
    }
    public int minMeetingRooms1(Interval[] intervals) {
        List<Integer> startTimes = new ArrayList<>();
        Map<Integer, List<Integer>> startToEndTimes= new HashMap<>();

        for (Interval i : intervals) {
            startTimes.add(i.start);
            startToEndTimes.putIfAbsent(i.start, new ArrayList<>());
            startToEndTimes.get(i.start).add(i.end);
        }

        Collections.sort(startTimes);
        for (Integer start : startToEndTimes.keySet()) {
            Collections.sort(startToEndTimes.get(start));
        }

        int count=0;
        while(!startTimes.isEmpty()) {
            count++;
            System.out.println("starting to prepare room: ");
            int last_end = 0;
            while (findGE(startTimes, last_end, 0, startTimes.size() - 1) >= 0) {
                int start_time_index = findGE(startTimes, last_end, 0, startTimes.size() - 1);
                int start_time = startTimes.get(start_time_index);
                last_end = startToEndTimes.get(start_time).get(0);

                System.out.println("[" + start_time + "->" + last_end + "],");

                startToEndTimes.get(start_time).remove(0);
                startTimes.remove(start_time_index);
                if (startToEndTimes.get(start_time).isEmpty()) {
                    startToEndTimes.remove(start_time);
                }
            }
            System.out.println("room is full\n");
        }
        return count;
    }

    public int findGE(List<Integer> list, int key, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            if (list.get(start) >= key) {
                return start;
            } else {
                return -1;
            }
        }
        int mid = (start+end)/2;
        if (list.get(mid) == key)  {
            return mid;
        } else if (list.get(mid) > key) {
            return findGE(list, key, start, mid);
        } else {
            return findGE(list, key, mid+1, end);
        }

    }
}
