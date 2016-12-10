package xin.leetcode.nextpermutation_31;

import java.util.Arrays;

/**
 * Created by Xin on 9/2/2016.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {5,1,1};
        solution.nextPermutation(nums);
        Arrays.stream(nums).forEach(e -> System.out.print(e + " "));
    }
}
