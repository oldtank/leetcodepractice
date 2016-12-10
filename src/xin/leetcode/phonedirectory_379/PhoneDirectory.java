package xin.leetcode.phonedirectory_379;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Xin on 9/6/2016.
 */
public class PhoneDirectory {
    boolean isAvailable[];
    Queue<Integer> availables;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        isAvailable = new boolean[maxNumbers+1];
        availables = new ArrayDeque<>();
        for (int i=0; i<=maxNumbers; i++) {
            isAvailable[i] = true;
            availables.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (!availables.isEmpty()) {
            int toAssign = availables.poll();
            isAvailable[toAssign] = false;
            return toAssign;
        } else {
            return -1;
        }
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return isAvailable[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        isAvailable[number] = true;
        availables.offer(number);
    }
}
