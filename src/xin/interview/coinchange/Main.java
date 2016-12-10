package xin.interview.coinchange;

/**
 * Created by Xin on 11/27/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] coins= {2, 5, 3, 6};
        int amount = 10;
        System.out.println(new Solution().numberOfWays(amount, coins));

    }
}
