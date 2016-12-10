package xin.sorting.heap;

import java.util.ArrayList;

/**
 * Created by Xin on 7/17/2016.
 */
public class MaxHeap<T extends Comparable> extends HeapBase<T> {
    void build() {
        // ignoring index 0
        for (int i = heapSize / 2; i >= 1; i--) {
            heapify(i);
        }
    }

    MaxHeap(ArrayList<T> heap, int size) {
        super(heap, size);
        this.build();
    }

    public void sort() {
        for (int i = heapSize; i >= 2; i--) {
            exchange(1, i);
            heapSize--;
            heapify(1);
        }
    }

    @Override
    public void print() {
        super.print();
    }

    @Override
    void heapify(int i) {
        int leftIndex = left(i);
        int rightIndex = right(i);
        int largestIndex = i;
        if (leftIndex > 0 && heap.get(leftIndex).compareTo(heap.get(i)) > 0) {
            largestIndex = leftIndex;
        }
        if (rightIndex > 0 && heap.get(rightIndex).compareTo(heap.get(largestIndex)) >0 ){
            largestIndex = rightIndex;
        }

        if (largestIndex != i) {
            exchange(i, largestIndex);
            heapify(largestIndex);
        }
    }

    public void increaseValue(int i, T newValue) {
        heap.set(i, newValue);
        while(parent(i) > 0 && heap.get(parent(i)).compareTo(newValue) < 0) {
            exchange(parent(i), i);
            i = parent(i);
        }
    }

    public void add(T value) {
        heapSize++;
        if (heap.size() == heapSize) {
            heap.add(value);
        }
        increaseValue(heapSize, value);
    }
}
