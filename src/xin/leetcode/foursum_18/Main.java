package xin.leetcode.foursum_18;

import java.util.List;

/**
 * Created by Xin on 11/27/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums= {1, 0, -1, 0, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = new Solution().fourSum(nums, target);
        for (int i=0; i<result.size(); i++) {
            for (int j=0; j<result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
