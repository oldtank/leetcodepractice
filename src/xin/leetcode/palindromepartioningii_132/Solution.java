package xin.leetcode.palindromepartioningii_132;

/**
 * Created by Xin on 11/24/2016.
 */
public class Solution {
    public int minCut(String s) {
        // cuts[i][j]: cuts needed for substring from index i to index j
        int[][] cuts = new int[s.length()][s.length()];

        for (int N=1; N < s.length(); N++) {
            for (int i = 0; i + N < s.length(); i++) {
                int j = i + N;
                String currS = s.substring(i, j + 1);
                if (isPalindrome(currS)) {
                    cuts[i][j] = 0;
                    continue;
                }
                cuts[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k <= j; k++) {
                    cuts[i][j] = Math.min(cuts[i][j], 1 + cuts[i][k - 1]
                            + cuts[k][j]);
                }
            }
        }
        return cuts[0][s.length()-1];
    }

    boolean isPalindrome(String s) {
        int i=0, j = s.length()-1;
        while (i<j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}