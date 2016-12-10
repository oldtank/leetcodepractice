package xin.leetcode.guessnumberhigherorlower_374;

/**
 * Created by Xin on 10/2/2016.
 */
public class GuessGame {
    static int guess(int i) {
        if (i == 1) {
            return 0;
        } else if (i < 1) {
            return 1;
        } else {
            return -1;
        }
    }
}
