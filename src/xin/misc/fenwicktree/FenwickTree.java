package xin.misc.fenwicktree;

/**
 * Created by Xin on 10/1/2016.
 */
public class FenwickTree {
    int[] ft;

    public int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += ft[i];
            i = i - (i & -1 * i);
        }
        return sum;
    }

    public FenwickTree(int[] nums) {
        int n = nums.length;
        ft = new int[n+1];
        for (int i=0; i<n; i++) {
            increment(i, nums[i]);
        }
    }

    public void increment(int i, int toAdd) {
        i++;
        while (i <= ft.length) {
            ft[i] += toAdd;
            i = i + (i & -1 * i);
        }
    }
}
