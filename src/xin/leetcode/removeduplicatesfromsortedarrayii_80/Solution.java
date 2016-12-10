package xin.leetcode.removeduplicatesfromsortedarrayii_80;

/**
 * Created by Xin on 10/5/2016.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        boolean almost = false;
        int posNew = 0;
        for (int posOld=1; posOld<nums.length; posOld++) {
            if (nums[posOld] != nums[posOld-1]) {
                nums[++posNew] = nums[posOld];
                almost = false;
            } else {
                if (almost) {

                } else {
                    almost = true;
                    nums[++posNew] = nums[posOld];
                }
            }
        }
        return posNew+1;
    }
}