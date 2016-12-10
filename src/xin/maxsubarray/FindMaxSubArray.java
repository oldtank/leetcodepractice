package xin.maxsubarray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 6/19/2016.
 */
public class FindMaxSubArray {
    public static MaxSubArray findMaxSubArray(List<Integer> list) {
        MaxSubArray maxSubArray = new MaxSubArray(list.get(0), 0, 0);
        List<MaxSubArray> maxSubArrayEndingHere = new ArrayList<>();
        maxSubArrayEndingHere.add(0, new MaxSubArray(list.get(0), 0, 0));
        for (int i = 1; i < list.size(); i++) {
            int value = list.get(i);
            MaxSubArray here = new MaxSubArray(value, i, i);
            if (value < maxSubArrayEndingHere.get(i-1).getMax() + value) {
                here.setMax(maxSubArrayEndingHere.get(i-1).getMax() + value);
                here.setStart(maxSubArrayEndingHere.get(i-1).getStart());
            }
            maxSubArrayEndingHere.add(i, here);
        }
        maxSubArrayEndingHere.forEach(ending -> {
            if (maxSubArray.getMax() < ending.getMax()) {
                maxSubArray.setMax(ending.getMax());
                maxSubArray.setStart(ending.getStart());
                maxSubArray.setEnd(ending.getEnd());
            }
        });
        return maxSubArray;
    }
}
