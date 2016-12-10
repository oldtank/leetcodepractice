package xin.leetcode.utf8_393;

/**
 * Created by Xin on 10/2/2016.
 */
public class Solution {

    public boolean validUtf8(int[] data) {
        if (data.length == 0) {
            return true;
        }
        for(int i=0; i<data.length;) {
            int numOfOnes = numOfOnes(data[i]);
            //follow by 0
            if ( (data[i] & (1 << (7-numOfOnes))) !=0) {
                return false;
            }

            if (numOfOnes == 1 ||  i+numOfOnes-1 > data.length) {
                return false;
            }

            for (int j=0; j<numOfOnes-1; j++) {
                i++;
                if ( (data[i] & (1 << 7)) != Math.pow(2, 7)
                        || (data[i] & (1 << 6)) != 0 ) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public int numOfOnes(int num) {
        int count = 0;
        int mask = (int) Math.pow(2, 7);
        while (mask >= 2) {
            if ( (mask & num) == mask) {
                count ++;
                mask /= 2;
            } else {
                break;
            }
        }
        return count;
    }
}