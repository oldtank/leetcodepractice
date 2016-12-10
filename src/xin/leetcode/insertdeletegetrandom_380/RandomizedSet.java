package xin.leetcode.insertdeletegetrandom_380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Xin on 9/20/2016.
 */
public class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer, Integer> valuePosMap;
    int endIndex;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        endIndex = -1;
        list = new ArrayList<>();
        valuePosMap = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valuePosMap.containsKey(val)) {
            return false;
        } else {
            if (endIndex == list.size() - 1) {
                list.add(val);
                endIndex++;
            } else {
                list.set(++endIndex, val);
            }
            valuePosMap.put(val, endIndex);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valuePosMap.containsKey(val)) {
            return false;
        } else {
            int pos = valuePosMap.get(val);
            if (pos == endIndex) {
                endIndex-- ;
            } else {
                int last = list.get(endIndex);
                list.set(pos, last);
                valuePosMap.put(last, pos);
                endIndex--;
            }
            valuePosMap.remove(val);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int pos = rand.nextInt(endIndex+1);
        return list.get(pos);
    }
}