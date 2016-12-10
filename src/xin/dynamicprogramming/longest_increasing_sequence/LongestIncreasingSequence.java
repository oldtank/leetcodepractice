package xin.dynamicprogramming.longest_increasing_sequence;

import xin.general.GeneralUtil;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Xin on 7/27/2016.
 */
public class LongestIncreasingSequence {

    public static void main(String[] args) {
        int[] array =  {2, 5, 3, 7, 11, 8, 12, 9};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<array.length; i++) {
            list.add(array[i]);
        }
        System.out.println(findLongest(list));
        System.out.println(findLongestEfficient(list));
    }

    public static int findLongest(ArrayList<Integer> list) {
        ArrayList<Integer> longestEndingHere = new ArrayList<>();
        for (int i=0; i< list.size(); i++) {
            longestEndingHere.add(1);
        }

        for (int i=1; i<list.size(); i++) {
            for (int j =0; j<i; j++) {
                if (list.get(i) > list.get(j) && longestEndingHere.get(i) < longestEndingHere.get(j) + 1) {
                    longestEndingHere.set(i, longestEndingHere.get(j) + 1);
                }
            }
        }
        return longestEndingHere.get(list.size()-1);
    }

    public static int findCeil(ArrayList<Integer> list, int start, int end, int key) {
        if (start > end) {
            return -1;
        }

        if (end == start) {
            if (list.get(start) > key) {
                return start;
            } else {
                return -1;
            }
        }

        int mid = (start + end) / 2;
        if (list.get(mid) <= key) {
            return findCeil(list, mid + 1, end, key);
        } else {
            return findCeil(list, start, mid, key);
        }
    }

    public static int findLongestEfficient(ArrayList<Integer> list) {
        // longest sequence of length i ends at tailValue[i]
        ArrayList<Integer> tailValues = GeneralUtil.initializeArrayList(list.size()+1);
        tailValues.set(1, list.get(0));
        int longestLength = 1;
        for (int i = 1; i < list.size(); i++) {
            if (tailValues.get(longestLength) < list.get(i)) {
                longestLength ++;
                tailValues.set(longestLength, list.get(i));
            } else {
                // find the ceiling in tailValue, and replace it with list[i]
                int ceil = findCeil(tailValues, 1, longestLength, list.get(i));
                if (ceil > 0) {
                    tailValues.set(ceil, list.get(i));
                }
            }
        }
        GeneralUtil.printList(tailValues);
        return longestLength;
    }
}
