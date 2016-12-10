package xin.misc.binarysearch;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Xin on 11/17/2016.
 */
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[20];
        for (int i=0; i<nums.length; i++) {
            nums[i] = rand.nextInt(100);
        }

        Arrays.sort(nums);
        print(nums);
        BinarySearch binarySearch = new BinarySearch();
        int key = rand.nextInt(100);
        System.out.println("key is " + key);
        int findExactPos = binarySearch.findExact(key, nums);
        System.out.println("pos: " + findExactPos +" " +
                (findExactPos > 0 ? nums[findExactPos] : ""));

        int findFloor = binarySearch.findFloor(key, nums);
        System.out.println("floor: " + findFloor + " " +
                (findFloor > 0 ? nums[findFloor] : ""));

        int findCeiling = binarySearch.findCeiling(key, nums);
        System.out.println("ceiling: " + findCeiling + " " +
                (findCeiling > 0 ? nums[findCeiling] : ""));
    }

    public static void print(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
