package xin.leetcode.meetingroomsii_253;

/**
 * Created by Xin on 9/2/2016.
 */
public class Main {
    public static void main(String[] args) {
        Interval intervals[] = {
                new Interval(0,5),
                new Interval(0, 12),
                new Interval(0, 20),
                new Interval(6,10),
                new Interval(6,15),
                new Interval(12,20),
                new Interval(10,20),
                new Interval(16,30)};

        Solution solution = new Solution();
        System.out.println("we need " + solution.minMeetingRooms(intervals));
        System.out.println();
        System.out.println("we need " + solution.minMeetingRooms1(intervals));
    }
}
