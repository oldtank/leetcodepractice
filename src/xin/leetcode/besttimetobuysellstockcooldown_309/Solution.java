package xin.leetcode.besttimetobuysellstockcooldown_309;

/**
 * Created by Xin on 9/6/2016.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <=1) {
            return 0;
        }
        if (prices.length == 2) {
            return Math.max(0, prices[1]-prices[0]);
        }

        int n = prices.length;
        int values[] = new int[n];
        values[n-1] = 0;
        values[n-2] = Math.max(0, prices[n-1] - prices[n-2]);

        int[] maxSellHere = new int[n];
        maxSellHere[n-1] = prices[n-1];
        maxSellHere[n-2] = Math.max(prices[n-2], maxSellHere[n-1]);
        for (int i=n-3; i>=0; i--) {
            //not buying at i
            values[i] = values[i+1];

            //buying at i
            values[i] = Math.max(values[i], maxSellHere[i+1] - prices[i]);
            maxSellHere[i] = Math.max(prices[i] + values[i+2], maxSellHere[i+1]);
        }
        for (int i : maxSellHere) {
            System.out.print(i + " ");
        }
        System.out.println();
        return values[0];
    }
}