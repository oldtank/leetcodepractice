package xin.sorting.heap;

import xin.general.GeneralUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xin on 7/17/2016.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] array = {0, 4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
//        GeneralUtil.printList(list);
//        MaxHeap maxHeap = new MaxHeap(list, list.size() - 1);
//        maxHeap.printAsTree();

        PriorityQueue<Integer> queue = new PriorityQueue<>(list);
        System.out.println(queue.getMax());
        queue.increaseValue(4, 20);
        queue.getHeap().printAsTree();
        queue.add(50);
        queue.getHeap().printAsTree();
    }
}
