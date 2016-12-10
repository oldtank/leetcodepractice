package xin.misc.binarysearch;

/**
 * Created by Xin on 11/17/2016.
 */
public class BinarySearch {
    public int findExact(int key, int[] nums) {
        int start = 0, end=nums.length-1;
        while (start<=end) {
            int mid = (start+end)/2;
            if (nums[mid] == key) {
                return mid;
            }
            if (nums[mid] < key) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }

    // find biggest number smaller or equal to key
    public int findFloor(int key, int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (nums[mid] == key) {
                return mid;
            }
            if (key < nums[mid]) {
                end = mid-1;
            } else {
                if (mid+1 == nums.length || nums[mid+1] > key) {
                    return mid;
                } else {
                    start = mid+1;
                }
            }
        }
        return -1;
    }

    // find smallest number bigger or equal to key
    public int findCeiling(int key, int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) /2;
            if (nums[mid] == key) {
                return mid;
            }
            if (nums[mid] < key) {
                start = mid+1;
            } else {
                if (mid == 0 || nums[mid-1] < key) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
