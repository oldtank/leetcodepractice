package xin.leetcode.productofarrayexceptself_238;

/**
 * Created by Xin on 10/3/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {0,0};
        int[] result = new Solution().productExceptSelf(nums);
        for(int i: result) {
            System.out.println(i);
        }
    }
}
