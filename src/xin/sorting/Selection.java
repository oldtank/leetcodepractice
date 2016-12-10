package xin.sorting;

import xin.general.GeneralUtil;

import java.util.ArrayList;

/**
 * Created by Xin on 7/20/2016.
 */
public class Selection {
    public static <T extends Comparable> T findith(ArrayList<T> list, int p, int r, int i) {
//        System.out.println(p + " " + r + " " +i);
        if (p == r) {
            return list.get(p);
        }
        int q = QuickSort.partition(list, p, r);
        GeneralUtil.printList(list);
//        System.out.println(q);
        int j = q - p + 1; // pivot is at jth position
        if (j == i) {
            return list.get(q);
        } else {
            if (j > i) { // find on the left side of pivot
                return findith(list, p, q-1, i);
            } else { // find on the right side of pivot
                return findith(list, q+1, r, i-j);
            }
        }
    }
}
