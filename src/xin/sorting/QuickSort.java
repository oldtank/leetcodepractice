package xin.sorting;

import java.util.ArrayList;

/**
 * Created by Xin on 7/18/2016.
 */
public class QuickSort {

    public static <T extends Comparable> void sort(ArrayList<T> list, int start, int end) {
        if (start < end) {
            int pivot = partition(list, start, end);
            sort(list, start, pivot - 1);
            sort(list, pivot + 1, end);
        }
    }

    public static <T extends Comparable> int partition(ArrayList<T> list, int start, int end) {
        T pivot = list.get(end);
        int i = start  - 1;
        for (int j = start; j <= end - 1; j++ ) {
            if (list.get(j).compareTo(pivot) <= 0) {
                exchange(list, i + 1, j);
                i++;
            }
        }
        exchange(list, i + 1, end);
        return i + 1;
    }

    private static <T extends Comparable> void exchange(ArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
