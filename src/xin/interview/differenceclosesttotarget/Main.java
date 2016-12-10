package xin.interview.differenceclosesttotarget;

/**
 * Created by Xin on 10/8/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-8,-5,2, 6, 20, 100};
        int target = 20;
        System.out.println(new Solution().findClosestDifference(nums, target));
    }
}
