package xin.leetcode.mediandatastream_295;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Xin on 9/8/2016.
 */
public class MedianFinder {
    PriorityQueue<Integer> lowerMaxHeap;
    PriorityQueue<Integer> upperMinHeap;

    public MedianFinder() {
        Comparator<Integer> desccmp = (a, b) -> (b-a);
        lowerMaxHeap = new PriorityQueue<>(desccmp);
        upperMinHeap = new PriorityQueue<>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (lowerMaxHeap.isEmpty() && upperMinHeap.isEmpty()) {
            lowerMaxHeap.offer(num);
            return;
        }
        if (!lowerMaxHeap.isEmpty() && num<=lowerMaxHeap.peek()) {
            if (lowerMaxHeap.size() == upperMinHeap.size()+1) {
                int top = lowerMaxHeap.poll();
                upperMinHeap.offer(top);
                lowerMaxHeap.offer(num);
            } else {
                lowerMaxHeap.offer(num);
            }
            return;
        }
        if (!upperMinHeap.isEmpty() && num >= upperMinHeap.peek()) {
            if (upperMinHeap.size() == lowerMaxHeap.size()+1) {
                int top = upperMinHeap.poll();
                lowerMaxHeap.offer(top);
                upperMinHeap.offer(num);
            } else {
                upperMinHeap.offer(num);
            }
            return;
        }
        if (lowerMaxHeap.size() <= upperMinHeap.size()) {
            lowerMaxHeap.offer(num);
        } else {
            upperMinHeap.offer(num);
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (lowerMaxHeap.isEmpty() && !upperMinHeap.isEmpty()) {
            return upperMinHeap.peek();
        } else if (!lowerMaxHeap.isEmpty() && upperMinHeap.isEmpty()) {
            return lowerMaxHeap.peek();
        } else {
            if (lowerMaxHeap.size() > upperMinHeap.size()) {
                return lowerMaxHeap.peek();
            } else if (lowerMaxHeap.size() < upperMinHeap.size()) {
                return  upperMinHeap.peek();
            } else {
                return (lowerMaxHeap.peek()+upperMinHeap.peek())/2.0;
            }
        }
    }
}
