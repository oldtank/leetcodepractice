package xin.leetcode.addbinary_67;

/**
 * Created by Xin on 10/6/2016.
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int carry = 0;
        while (i>=0 || j>=0) {
            int ia = i >=0 ? a.charAt(i) - '0' : 0;
            int ib = j >=0 ? b.charAt(j) -'0' : 0;
            i--;
            j--;
            sb.insert(0, (ia+ib +carry)%2);
            carry = (ia+ib+carry)/2;
        }
        if (carry > 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}