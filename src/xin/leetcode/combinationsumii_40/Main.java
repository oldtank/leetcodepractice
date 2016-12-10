package xin.leetcode.combinationsumii_40;

import java.util.List;

/**
 * Created by Xin on 11/15/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = new Solution().combinationSum2(candidates, target);
        result.forEach(list -> {
            list.forEach(n -> System.out.print(n + " "));
            System.out.println();
        });
    }
}
