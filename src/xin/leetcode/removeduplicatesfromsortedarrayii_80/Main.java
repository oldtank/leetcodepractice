package xin.leetcode.removeduplicatesfromsortedarrayii_80;

/**
 * Created by Xin on 10/5/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,2,2,3};
        System.out.println(new Solution().removeDuplicates(nums));
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
