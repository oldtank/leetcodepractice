package xin.sorting.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 7/17/2016.
 */
public class HeapBase<T> {
    ArrayList<T> heap;
    int heapSize = 0;

    HeapBase(ArrayList<T> heap, int size) {
        this.heap = heap;
        this.heapSize= size;
    }

    public T get(int i) {
        return heap.get(i);
    }

    public void resetHeapSize() {
        this.heapSize = heap.size() - 1;
    }

    int parent(int i) {
        if (i == 1) {
            return -1;
        }
        return i/2;
    }

    int left(int i) {
        if (i * 2 <= heapSize ) {
            return i * 2;
        } else {
            return -1;
        }
    }

    int right(int i) {
        if (i * 2 + 1 <= heapSize) {
            return i * 2 + 1;
        } else {
            return -1;
        }
    }

    void exchange(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    void heapify(int i) {}

    public void print() {
        for (int i = 1; i <= heapSize; i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }

    public void sort() {}

    public void printAsTree() {
        printAsTree(1, "", true);
    }

    public void printAsTree(int index, String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└-" : "|-") + heap.get(index));
        if (left(index) > 0) {
            if (right(index) < 0) {
                printAsTree(left(index), prefix + (isTail ? "  " : "| "), true);
            } else {
                printAsTree(left(index), prefix + (isTail ? "  " : "| "), false);
                printAsTree(right(index), prefix + (isTail ? "  " : "| "), true);
            }
        }
    }
}
