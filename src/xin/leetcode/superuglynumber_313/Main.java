package xin.leetcode.superuglynumber_313;

/**
 * Created by Xin on 9/5/2016.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int primes[] = {2,7,13,19};
        int n = 6;
        System.out.println(solution.nthSuperUglyNumber(n, primes));
    }
}
