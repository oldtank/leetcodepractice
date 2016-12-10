package xin.dynamicprogramming;

import xin.general.GeneralUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xin on 8/9/2016.
 */
public class KnapsackNonFractional {

    public static void main(String[] args) {
        ArrayList<Integer> weights = new ArrayList<>();
        weights.add(10);
        weights.add(20);
        weights.add(30);
        ArrayList<Integer> values = new ArrayList<>();
        values.add(60);
        values.add(100);
        values.add(120);

        int max_weight = 50;
        steal(weights, values, max_weight);
    }

    public static void steal(ArrayList<Integer> weights, ArrayList<Integer> values, int max_weight) {
        // maxSofar.get(i).get(j): max value when knacksack has max weight of i, using items 0 - j
        Map<Integer, Map<Integer, Integer>> maxSofar = new HashMap<>();

        int num_of_items = weights.size();
        Map<Integer, Integer> upTo_values = new HashMap<>();
        for (int i=0; i<num_of_items; i++) {
            upTo_values.put(i, 0);
        }
        maxSofar.put(0, upTo_values);

        int result = steal_helper(weights, values, max_weight, num_of_items-1, maxSofar);
        System.out.println(result);
    }

    public static int steal_helper(ArrayList<Integer> weights, ArrayList<Integer> values, int max_weight, int upToItem, Map<Integer, Map<Integer, Integer>> maxSofar) {

        if (maxSofar.get(max_weight) != null && maxSofar.get(max_weight).get(upToItem) != null) {
            return maxSofar.get(max_weight).get(upToItem);
        }

        if (upToItem < 0) {
            return 0;
        }

        if (maxSofar.get(max_weight) == null) {
            maxSofar.put(max_weight, new HashMap<Integer, Integer>());
        }
        int current_max = 0;
        if (max_weight < weights.get(upToItem)) {
            current_max = steal_helper(weights, values, max_weight, upToItem-1, maxSofar);
        } else {
            current_max = max(steal_helper(weights, values, max_weight, upToItem - 1, maxSofar),
                    values.get(upToItem) + steal_helper(weights, values, max_weight - weights.get(upToItem), upToItem - 1, maxSofar));
        }
        maxSofar.get(max_weight).put(upToItem, current_max);
        return current_max;

    }

    public static int max(int a, int b) {
        return a>b?a:b;
    }

    public static int findFloor(ArrayList<Integer> list, int end, int key) {
        int curr = end;
        for (; curr>=0; curr--) {
            if (list.get(curr) <= key) {
                break;
            }
        }
        return curr;
    }
}
