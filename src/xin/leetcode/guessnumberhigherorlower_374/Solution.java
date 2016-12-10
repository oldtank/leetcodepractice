package xin.leetcode.guessnumberhigherorlower_374;

/**
 * Created by Xin on 10/2/2016.
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left=1, right=n;
        while (left <= right) {
            int mid = left + (right - left)/2;
            System.out.println("mid: " + mid);
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                left = mid+1;
            } else if (guess(mid) == -1) {
                right = mid-1;
            }
        }
        return -1;
    }
}