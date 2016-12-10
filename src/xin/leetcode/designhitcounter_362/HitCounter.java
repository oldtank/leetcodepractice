package xin.leetcode.designhitcounter_362;

/**
 * Created by Xin on 10/2/2016.
 */
public class HitCounter {
    int[] hits;
    int[] times;
    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new int[300];
        times = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int i = (timestamp-1) % 300;
        if (times[i] == timestamp) {
            hits[i] ++;
        } else {
            hits[i] = 1;
            times[i] = timestamp;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for (int i=0; i<300; i++) {
            if (timestamp - times[i] < 300) {
                count += hits[i];
            }
        }
        return count;
    }
}