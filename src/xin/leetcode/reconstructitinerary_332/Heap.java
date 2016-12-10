package xin.leetcode.reconstructitinerary_332;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/3/2016.
 */
public class Heap {
    int capacity;
    String array[];
    int size;

    public Heap(int capacity) {
        array = new String[capacity+1];
        this.capacity = capacity;
        size = 0;
    }

    public int parent(int i) {
        return i/2;
    }

    public int left(int i) {
        if (i*2 <= size) {
            return i*2;
        } else {
            return 0;
        }
    }

    public int right(int i) {
        if (i*2+1 <= size) {
            return i*2+1;
        } else {
            return 0;
        }
    }

    public void bottomUp(int i) {
        while (parent(i) >0) {
            if (array[i].compareTo(array[parent(i)]) <0) {
                swap(i, parent(i));
                i=parent(i);
            } else {
                break;
            }
        }
    }

    public void topDown(int i) {
        while (i <= size/2) {
            int smallIndex = i;
            if (left(i) > 0 && array[left(i)].compareTo(array[i]) < 0) {
                smallIndex = left(i);
            }
            if (right(i) > 0 && array[right(i)].compareTo(array[smallIndex]) < 0) {
                smallIndex = right(i);
            }
            if (smallIndex == i) {
                break;
            } else {
                swap(i, smallIndex);
                i = smallIndex;
            }
        }
    }

    public void insert(String s) {
        if (size < capacity) {
            array[size+1] = s;
            size++;
            bottomUp(size);
        } else {
            throw new RuntimeException("heap is full");
        }
    }

    public String getMin() {
        if (size > 0) {
            String min = array[1];
            swap(1, size);
            size--;
            topDown(1);
            return min;
        } else {
            throw new RuntimeException("heap is empty");
        }
    }

    public void swap(int i, int j) {
        String tmp = array[i];
        array[i]= array[j];
        array[j] = tmp;
    }
}
