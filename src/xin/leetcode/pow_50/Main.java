package xin.leetcode.pow_50;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xin on 8/25/2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(myPow(1.0001, 123456));
    }

    public static double myPow(double x, int n) {
        if (x==0) {
            return 0;
        } else if (n==0) {
            return 1;
        } else if (n < 0) {
            return 1/powHelper(x, -1*n);
        } else {
            return powHelper(x, n);
        }
    }

    public static double powHelper( double x, int n) {
        if (n==0) {
            return 1;
        }
        double sqrt = powHelper(x, n/2);
        if (n%2 == 0) {
            return sqrt*sqrt;
        } else {
            return x*sqrt*sqrt;
        }
    }
}
