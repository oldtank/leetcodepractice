package xin.sorting;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Xin on 6/7/2016.
 */
public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        sort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] array, int start, int end) {
        if (start == end) {
            return;
        }
        sort(array, start, (start + end)/2);
        sort(array, (start + end)/2 + 1, end);
        merge(array, start, (start + end) / 2, end);
    }

    private static <T extends Comparable<T>> void merge(T[] array, int start, int mid, int end) {
        T[] left = (T[]) Array.newInstance(array.getClass().getComponentType(), mid - start + 1);
        T[] right = (T[]) Array.newInstance(array.getClass().getComponentType(), end - mid);
        for (int i = start; i <= mid;i++) {
            left[i - start] = array[i];
        }
        for (int i = mid + 1; i <= end; i++) {
            right[i - mid - 1] = array[i];
        }
        for (int i = start, index_l = 0, index_r = 0; i <= end; i++) {
            if (index_l >= mid - start + 1) {
                array[i] = right[index_r];
                index_r ++;
                continue;
            }
            if (index_r >= end - mid) {
                array[i] = left[index_l];
                index_l ++;
                continue;
            }
            if (left[index_l].compareTo(right[index_r]) <= 0) {
                array[i] = left[index_l];
                index_l++;
            } else {
                array[i]= right[index_r];
                index_r++;
            }
        }
    }
}
