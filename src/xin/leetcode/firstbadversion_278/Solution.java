package xin.leetcode.firstbadversion_278;

/**
 * Created by Xin on 11/26/2016.
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = (left+right)/2;
            if (isBadVersion(mid)) {
                if (mid==left || (mid > left && !isBadVersion(mid-1))) {
                    return mid;
                } else {
                    right = mid-1;
                }
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

}
