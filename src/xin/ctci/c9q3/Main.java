package xin.ctci.c9q3;

import java.util.ArrayList;

/**
 * Created by Xin on 8/22/2016.
 */
public class Main {

    public static void main(String[] args) {
        int[] array = {-10,-5,2,2,2,3,4,8,9,12,13};
        printList(array);
        System.out.println(findMagicIndexWithDuplicates(array, 0, array.length-1));
    }

    public static int findMagicIndex(int[] list, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left+right)/2;
        if (list[mid] == mid) {
            return mid;
        } else if (list[mid] > mid) {
            return findMagicIndex(list, left, mid-1);
        } else {
            return findMagicIndex(list, mid+1, right);
        }
    }

    public static int findMagicIndexWithDuplicates(int[] list, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left+right)/2;
        if (list[mid] == mid) {
            return mid;
        }
        if (list[mid] < mid) {
            //search right side
            int index = findMagicIndexWithDuplicates(list, mid+1, right);
            if (index >=0 ) {
                return index;
            } else {
                return findMagicIndexWithDuplicates(list, left, list[mid]);
            }
        } else {
            int index = findMagicIndexWithDuplicates(list, left, mid-1);
            if (index >= 0) {
                return index;
            } else {
                return findMagicIndexWithDuplicates(list, list[mid], right);
            }
        }
    }

    public static void printList(int[] list) {
        for(int e: list) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
}
