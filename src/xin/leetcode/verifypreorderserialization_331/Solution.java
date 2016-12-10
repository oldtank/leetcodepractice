package xin.leetcode.verifypreorderserialization_331;

/**
 * Created by Xin on 9/5/2016.
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 0) {
            return true;
        }
        String[] tokens = preorder.split(",");
        int end = helper(tokens, 0);
        if (end < (tokens.length-1) || end == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int helper(String[] preorder, int pos) {
        if (pos >= preorder.length) {
            return -1;
        }
        if (preorder[pos].equals("#")) {
            return pos;
        }
        int left_end = helper(preorder, pos+1);
        if (left_end == -1) {
            return -1;
        } else {
            int right_end = -1;
            if (left_end + 1 < preorder.length) {
                right_end = helper(preorder, left_end + 1);
            }
            return right_end;
        }
    }
}
