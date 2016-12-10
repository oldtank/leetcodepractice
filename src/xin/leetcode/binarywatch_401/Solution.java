package xin.leetcode.binarywatch_401;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/24/2016.
 */
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        int minutes[] = {32,16,8,4,2,1};
        int hours[] = {8,4,2,1};
        if(num == 0) {
            list.add("0:00");
            return list;
        }

        for (int i=0; i<=4 && i<=num; i++) {
            int hourDigits = i;
            int minuteDigits = num-i;
            if (minuteDigits > 6) {
                continue;
            }
//            List<Integer> hoursPicked = picNumber(hours, 0, i);
//            List<Integer> minutesPicked = picNumber(minutes, 0, num-i);
            List<Integer> hoursPicked = new ArrayList<>();
            picNumber(hours, 0, 0, i, hoursPicked);

            List<Integer> minutesPicked = new ArrayList<>();
            picNumber(minutes, 0,0,num-i,minutesPicked);
            for (int hour : hoursPicked) {
                if (hour > 11) {
                    continue;
                }
                for (int min : minutesPicked) {
                    if (min > 59) {
                        continue;
                    }
                    list.add(hour + ":" + String.format("%02d", min));
                }
            }
        }

        return list;
    }

    private void picNumber(int[] source, int pos, int curr_num, int target, List<Integer> list) {
        if (target == 0) {
            list.add(curr_num);
            return;
        }
        if (pos == source.length) {
            return;
        }

        // pick current pos
        picNumber(source, pos+1, curr_num+source[pos], target-1, list);

        //not picking current pos
        picNumber(source, pos+1, curr_num, target, list);
    }

    private List<Integer> picNumber(int[] source, int from, int num) {
        if (num==0) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        if (source.length-from == num) {
            List<Integer> list = new ArrayList<>();
            int n=0;
            for (int i=from; i<source.length; i++) {
                n += source[i];
            }
            list.add(n);
            return list;
        }
        List<Integer> list = new ArrayList<>();
        //current pos set to 1
        List<Integer> sub = picNumber(source, from+1, num-1);
        for (Integer i : sub) {
            list.add(source[from] + i);
        }

        //current pos set to 0
        List<Integer> sub1 = picNumber(source, from+1, num);
        for (Integer i: sub1) {
            list.add(i);
        }
        return list;
    }
}