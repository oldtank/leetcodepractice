package xin.leetcode.rangeadditon_370;

/**
 * Created by Xin on 9/7/2016.
 */
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int array[] = new int[length];
        for (int[] update : updates) {
            array[update[0]] += update[2];
            if (update[1] <= length-2) {
                array[update[1]+1] += -1*update[2];
            }
        }
        int cumulated=array[0];
        for (int i=1; i<length; i++) {
            cumulated += array[i];
            array[i] = cumulated;
        }
        return array;
    }
}
