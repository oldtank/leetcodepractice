package xin.leetcode.permutations_46;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xin on 8/26/2016.
 */
public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        List<List<Integer>> permutations = permute(nums);
        for (int i=0; i<permutations.size(); i++) {
            for (int j=0; j<permutations.get(i).size(); j++) {
                System.out.print(permutations.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permuteHelper(nums, 0, permutations);
        return permutations;
    }

    public static void permuteHelper(int[] nums, int pos, List<List<Integer>> permutations) {
        if (pos == nums.length-1) {
            List<Integer> permutation = new ArrayList<>();
            for (int i=0; i<nums.length; i++) {
                permutation.add(nums[i]);
            }
            permutations.add(permutation);
            return;
        }
        for (int i=pos; i<nums.length; i++) {
            swap(nums, pos, i);
            permuteHelper(nums, pos+1, permutations);
            swap(nums, pos, i);
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a]=nums[b];
        nums[b] = tmp;
    }
}
