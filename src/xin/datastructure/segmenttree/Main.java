package xin.datastructure.segmenttree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Xin on 9/27/2016.
 */
public class Main {
    public static void main(String[] args) {
        int numbers[] =  {1, 3, 5, 7, 9, 11};
        SegmentTree tree = new SegmentTree(numbers);
        System.out.println(tree.getSum(0, 0));
        System.out.println(tree.getSum(1, 2));
        System.out.println(tree.getSum(0, numbers.length-1));
        System.out.println(tree.getSum(2, 5));

        tree.update(3, 4);
        System.out.println(tree.getSum(0, 0));
        System.out.println(tree.getSum(1, 2));
        System.out.println(tree.getSum(0, numbers.length-1));
        System.out.println(tree.getSum(2, 5));

    }
}
