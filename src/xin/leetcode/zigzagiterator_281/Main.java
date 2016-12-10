package xin.leetcode.zigzagiterator_281;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Xin on 8/31/2016.
 */
public class Main {
    public static void main(String[] args) {
        Integer a1[] = {1,2,3};
        Integer a2[] = {4,5};

        List<Integer> l1 = Arrays.asList(a1);
        List<Integer> l2 = Arrays.asList(a2);

        ZigZagIterator z = new ZigZagIterator(l1, l2);
        while(z.hasNext()) {
            System.out.println(z.next());
        }
    }
}
