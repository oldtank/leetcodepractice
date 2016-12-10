package xin.leetcode.combinationsumiii_216;

import java.util.List;

/**
 * Created by Xin on 9/6/2016.
 */
public class Main {
    public static void main(String[] args) {
        int k=3, n=9;
        List<List<Integer>> lists = new Solution().combinationSum3(k, n);
        lists.forEach(list -> {
            list.forEach(e -> {
                System.out.print(e+" ");
            });
            System.out.println();
        });
    }
}
