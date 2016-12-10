package xin.leetcode.combinations_33;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * https://leetcode.com/problems/combinations/
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(combine(10, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        return combine(1, n, k);
    }

    public static List<List<Integer>> combine(int from, int to, int k) {
        if (k==0) {
            return new ArrayList<>();
        }
        if (k==1 && to>=from) {
            List<List<Integer>> lists = new ArrayList<>();
            for (int i=from; i<=to; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                lists.add(list);
            }
            return lists;
        }
        if (k == to-from+1) {
            List<Integer> list = new ArrayList<>();
            for (int i=from; i<=to; i++) {
                list.add(i);
            }
            List<List<Integer>> lists = new ArrayList<>();
            lists.add(list);
            return lists;
        }

        List<List<Integer>> lists = new ArrayList<>();
        for (int last=to; last-1-from +1 >= k-1; last--) {
            List<List<Integer>> tmpLists = combine(from, last-1, k-1);
            for (int i=0; i<tmpLists.size(); i++) {
                tmpLists.get(i).add(last);
            }
            lists.addAll(tmpLists);
        }
        return lists;
    }
}
