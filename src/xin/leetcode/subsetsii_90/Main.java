package xin.leetcode.subsetsii_90;

import java.util.List;

/**
 * Created by Xin on 10/5/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> subs = new Solution().subsetsWithDup(nums);

        subs.forEach(list -> {
            System.out.print("[");
            list.forEach(n -> System.out.print(n + " "));
            System.out.print("]");
            System.out.println();
        });
    }
}
