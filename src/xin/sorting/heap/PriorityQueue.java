package xin.sorting.heap;

import java.util.ArrayList;

/**
 * Created by Xin on 7/18/2016.
 */
public class PriorityQueue<T extends Comparable> {
    private MaxHeap<T> heap;

    public MaxHeap<T> getHeap() {
        return heap;
    }

    public PriorityQueue(ArrayList<T> data) {
        heap = new MaxHeap(data, data.size() - 1);
    }

    public T getMax() {
        return heap.get(1);
    }

    public void increaseValue(int i, T newValue) {
        heap.increaseValue(i, newValue);
    }

    public void add(T value) {
        heap.add(value);
    }

}
