package xin.leetcode.superuglynumber_313;

import java.util.*;

/**
 * Created by Xin on 9/5/2016.
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n==1) {
            return 1;
        }
        Map<Integer, Queue<Integer>> primeMultiples = new HashMap<>();
        for (int prime : primes) {
            primeMultiples.put(prime, new ArrayDeque<>());
            primeMultiples.get(prime).offer(prime);
        }
        int next=0;
        for (int i=2; i<=n; i++) {
            int min_from_index = 0;
            for (int j=min_from_index+1; j<primes.length; j++) {
                if (primeMultiples.get(primes[j]).peek() < primeMultiples.get(primes[min_from_index]).peek()) {
                    min_from_index = j;
                }
            }

            next = primeMultiples.get(primes[min_from_index]).poll();
            for (int j=min_from_index; j<primes.length; j++) {
                primeMultiples.get(primes[j]).offer(next*primes[j]);
            }
        }
        return next;
    }
}