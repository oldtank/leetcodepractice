package xin.leetcode.integer2roman;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xin on 8/26/2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(intToRoman(1900));
    }

    public static String intToRoman(int num) {
        String result = "";
        int val[]= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String roman[] ={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i=0; i<13; i++) {
            int count = num/val[i];
            num %= val[i];
            for (int j=0; j<count;j++) {
                result += roman[i];
            }
        }
        return result;
    }

    public static Map<Integer, String> initializeMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        return map;
    }

    public static int findCeiling(int[] completeRomans, int key) {
        int left=0, right = completeRomans.length-1;
        while (left <= right) {
            if (left == right) {
                if (completeRomans[left] >= key) {
                    return left;
                } else {
                    return -1;
                }
            }
            int mid = (left+right)/2;
            if (key == completeRomans[mid]) {
                return mid;
            } else if (key > completeRomans[mid]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
