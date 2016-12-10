package xin.misc;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.function.Function;

/**
 * Created by Xin on 8/14/2016.
 */
public class Main {
    public static void main(String[] args) {
        getRow(3);
    }

    public static List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> list = new LinkedList<>();
        if (rowIndex ==0) {
            return list;
        }
        list.add(1);
        if (rowIndex == 1) {
            return list;
        }
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int curr=1; curr<rowIndex; curr++) {
            for (int i=0; i<curr-1; i++) {
                list1.add(list.get(i) + list.get(i+1));
            }
            list1.addFirst(1);
            list1.add(1);

            list = list1;
            list1.clear();
        }
        return list;
    }
}
