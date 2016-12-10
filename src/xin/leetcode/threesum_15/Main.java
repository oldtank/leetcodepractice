package xin.leetcode.threesum_15;

import java.util.*;

/**
 * Created by Xin on 8/25/2016.
 */
public class Main {
    public static void main(String[] args) {
//        int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> tuples = threeSum1(nums);
        System.out.println(tuples);
    }


    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> table = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <= 2) {
            return result;
        }

        for (int i=0; i<=nums.length-3;i++) {
            if (i>=1 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i+1, right = nums.length-1;
            while(left < right) {
                if (nums[left] + nums[right] == -1*nums[i]) {
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[i]);
                    tuple.add(nums[left]);
                    tuple.add(nums[right]);
                    result.add(tuple);
                    left++;
                    right = nums.length-1;
                    while(nums[left] == nums[left-1] && left < nums.length-1) {
                        left++;
                    }
                } else if (nums[left] + nums[right] > -1*nums[i]) {
                    right --;
                } else if (nums[left] + nums[right] < -1*nums[i]) {
                    left++;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> table = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <= 2) {
            return result;
        }

        int fast = 2, slow = 2;
        while (fast < nums.length) {
            if (nums[slow] == nums[slow-1] && nums[slow] == nums[slow-2]) {
                if (nums[slow] == 0) {
                    nums[slow] = nums[fast];
                    slow++;
                    fast++;
                } else {
                    while(fast < nums.length && nums[fast] == nums[slow]) {
                        fast++;
                    }
                    if (fast == nums.length) {
                        break;
                    } else {
                        nums[slow] = nums[fast];
                        slow++;
                        fast++;
                    }
                }
            } else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }

        for (int i=0; i<=slow-1;i++) {

            List<List<Integer>> lists = twosum(nums, -1*nums[i], i+1, slow-1);
            if (lists.size() == 0) {
                continue;
            } else {
                for (int j=0; j<lists.size(); j++) {
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[i]);
                    tuple.addAll(lists.get(j));
                    if (!table.contains(tuple)) {
                        table.add(tuple);
                        result.add(tuple);
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> twosum(int[] nums, int target, int start, int end) {
        List<List<Integer>> lists = new ArrayList<>();
        int left = start, right = end;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                lists.add(list);
                left++;
                right = end;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return lists;
    }
}
