package xin.leetcode.excelsheetcolumntitle_168;

/**
 * Created by Xin on 10/5/2016.
 */
public class Solution {
    public String convertToTitle(int n) {
        if (n==0) {
            return "";
        }
        String title = "";
        while (n > 0){
            title = (char)((n-1)%26 + 'A') + title;
            n = (n - 1)/26;
        }
        return title;
    }
}
