package xin.leetcode.decodestring_394;

/**
 * Created by Xin on 9/24/2016.
 */
public class Solution {
    public String decodeString(String s) {
        return decode(s);
    }

    public String decode(String s) {
        int firstClosingIndex = s.indexOf(']');
        if (firstClosingIndex < 0) {
            return s;
        }
        int lastOpeningIndex = s.substring(0, firstClosingIndex).lastIndexOf('[');
        int repeat=0;
        int numIndex = lastOpeningIndex-1;
        for (int multiplier=1; numIndex >=0; numIndex--, multiplier*=10) {
            if (s.charAt(numIndex) >= '0' && s.charAt(numIndex) <= '9') {
                repeat += multiplier * (s.charAt(numIndex) - '0');
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        String repeated = s.substring(lastOpeningIndex+1, firstClosingIndex);
        for (int i=0; i<repeat; i++) {
            sb.append(repeated);
        }
        s= s.substring(0, numIndex+1) + sb.toString()+ s.substring(firstClosingIndex+1);
//        System.out.println(s);
        return decode(s);
    }
}