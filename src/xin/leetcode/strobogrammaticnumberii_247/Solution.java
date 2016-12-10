package xin.leetcode.strobogrammaticnumberii_247;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 9/3/2016.
 */
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        Map<Integer, List<String>> store  = new HashMap<>();
        store.put(0, new ArrayList<>());
        store.get(0).add("");

        store.put(1, new ArrayList<>());
        store.get(1).add("0");
        store.get(1).add("1");
        store.get(1).add("8");

        Map<Integer, Integer> maps = new HashMap<>();
        maps.put(1, 1);
        maps.put(6, 9);
        maps.put(8, 8);
        maps.put(9, 6);

        for (int i=2; i<=n; i++) {
            List<String> list = new ArrayList<>();
            List<String> subs = store.get(i-2);
            for(String sb : subs) {
                for (int key : maps.keySet()) {
                    list.add(key + sb + maps.get(key));
                }
                if (i != n) {
                    list.add("0" + sb + "0");
                }
            }
            store.put(i, list);
        }
        return store.get(n);
    }
}