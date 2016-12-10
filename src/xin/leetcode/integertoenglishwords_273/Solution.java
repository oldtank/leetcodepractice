package xin.leetcode.integertoenglishwords_273;

/**
 * Created by Xin on 11/16/2016.
 */
public class Solution {
    public String numberToWords(int num) {

        String[] THOUSANDS = {"", " thousand ", " million ", " billion "};

        if (num == 0) {
            return "zero";
        }

        int i=0;
        String word = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                word = helper(num%1000) + THOUSANDS[i] + word;
            }
            i++;
            num/=1000;
        }
        return word;
    }

    public String helper(int num) {
        String[] UNDER20 = {"", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] TENS = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
                "eighty", "ninety"};
        if (num ==0) {
            return "";
        } else if (num < 20) {
            return UNDER20[num];
        } else if (num < 100) {
            return TENS[num/10] + " " + UNDER20[num%10];
        } else {
            return UNDER20[num/100] + " hundred and " + helper(num%100);
        }
    }
}