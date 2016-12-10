package xin.sorting;

/**
 * Created by Xin on 6/6/2016.
 */
public class InsertionSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array.length <= 1) {
            return;
        }

        for (int curr = 1; curr < array.length; curr++) {
            if (array[curr].compareTo(array[curr-1]) >= 0) {
                continue;
            }
            int firstLarger;
            for (firstLarger = curr - 1; firstLarger >= 0; firstLarger--) {
                if (array[firstLarger].compareTo(array[curr]) < 0) {
                    break;
                }
            }
            firstLarger++;
            insert(array, firstLarger, curr);
        }
    }

    private static <T extends Comparable<T>> void insert(T[] array, int dest, int orig) {
        if (orig <= dest) {
            throw new RuntimeException("index of original position should be behind the destination position");
        }
        if (dest >= array.length || orig >= array.length) {
            throw new RuntimeException("dest or orig position is out of bound");
        }

        T orig_val = array[orig];
        for (int curr = orig; curr > dest; curr--) {
            array[curr] = array[curr-1];
        }
        array[dest] = orig_val;
    }
}
