package xin.sorting;

import java.util.ArrayList;

/**
 * Created by Xin on 7/19/2016.
 */
public class CountingSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> list) {
        ArrayList<Integer> count = initCountList(findMax(list) + 1);
        list.forEach(num -> {
            count.set(num, count.get(num) + 1);
        });
        for (int i=1; i<count.size(); i++) {
            count.set(i, count.get(i) + count.get(i-1));
        }
        ArrayList<Integer> sorted = initCountList(list.size());
        for (int i=list.size()-1; i>=0; i--) {
            sorted.set(count.get(list.get(i)) - 1, list.get(i));
            count.set(list.get(i), count.get(list.get(i)) - 1);
        }
        return sorted;
    }

    static int findMax(ArrayList<Integer> list) {
        int max = -1;
        for (Integer num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    static ArrayList<Integer> initCountList(int size) {
        ArrayList<Integer> count = new ArrayList<>();
        for (int i=0; i<size; i++) {
            count.add(0);
        }
        return count;
    }
}
