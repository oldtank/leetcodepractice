package xin.sorting;

import xin.general.GeneralUtil;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = GeneralUtil.generateRandomPositiveList(10);
        GeneralUtil.printList(list);
        System.out.println(Selection.findith(list, 0, list.size()-1, 5));
        QuickSort.sort(list, 0, list.size()-1);
        GeneralUtil.printList(list);
    }
}
