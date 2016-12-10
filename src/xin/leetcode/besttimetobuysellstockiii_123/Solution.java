package xin.leetcode.besttimetobuysellstockiii_123;

/**
 * Created by Xin on 10/7/2016.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] rights = new int[prices.length];
        rights[prices.length-1] = Integer.MIN_VALUE;
        for (int i=prices.length-2; i>=0; i--) {
            rights[i] = Math.max(rights[i+1], prices[i+1]);
        }


        int max = 0;
        int leftMinPrice = Integer.MAX_VALUE;
        int leftMaxProfit = Integer.MIN_VALUE;
        for (int i=0; i<prices.length; i++) {
            int leftProfit = i==0 ? 0 : Math.max(0, prices[i]-leftMinPrice);
            leftMaxProfit = Math.max(leftMaxProfit,leftProfit);
            int rightProfit = i==prices.length - 1? 0 : Math.max(0, rights[i] - prices[i]);
            System.out.println("left: " + leftMaxProfit + ",right: " + rightProfit);
            max = Math.max(max, rightProfit + leftMaxProfit);

            leftMinPrice = Math.min(leftMinPrice, prices[i]);
        }
        return max;
    }
}
