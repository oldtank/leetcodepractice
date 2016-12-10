package xin.leetcode.maximumproductofwordlength_318;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Xin on 9/2/2016.
 */
public class Solution {
    public int maxProduct(String[] words) {
        if (words.length < 2) {
            return 0;
        }
        int[][] charRecords = new int[words.length][26];
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<words[i].length(); j++) {
                charRecords[i][words[i].charAt(j)-'a']=1;
            }
        }
        int product = 0;
        for (int i=0; i<words.length-1; i++) {
            for (int j=i+1; j < words.length; j++) {
                if (!isOverlapping(charRecords, i, j)) {
                    product = Math.max(product, words[i].length()*words[j].length());
                }
            }
        }
        return product;
    }

    public boolean isOverlapping(int[][] charRecords, int i, int j) {
        for (int x=0; x<26; x++) {
            if (charRecords[i][x] == 1 && charRecords[j][x]==1){
                return true;
            }
        }
        return false;
    }
}