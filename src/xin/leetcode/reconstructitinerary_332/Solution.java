package xin.leetcode.reconstructitinerary_332;

import java.util.*;

/**
 * Created by Xin on 9/3/2016.
 */
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> list = new ArrayList<>();
        if (tickets.length == 0) {
            return list;
        }
        Map<String, List<String>> departureToDestMap = new HashMap<>();
        for (String[] ticket : tickets) {
            String depart = ticket[0];
            String dest = ticket[1];

            departureToDestMap.putIfAbsent(depart, new ArrayList());
            departureToDestMap.get(depart).add(dest);
        }

        for (String depart : departureToDestMap.keySet()) {
            Collections.sort(departureToDestMap.get(depart));
        }

        list.add("JFK");
        String last = "JFK";
//        while (departureToDestMap.get(last) != null) {
//            String dest;
//            List<String> destinations = departureToDestMap.get(last);
//            if (destinations.size() == 1) {
//                dest = departureToDestMap.get(last).get(0);
//            } else {
//                int i;
//                for (i=0; i<destinations.size(); i++) {
//                    if (departureToDestMap.get(destinations.get(i)) != null) {
//                        break;
//                    }
//                }
//                if (i<destinations.size()) {
//                    dest = destinations.get(i);
//                } else {
//                    dest = destinations.get(0);
//                }
//            }
//            list.add(dest);
//            destinations.remove(dest);
//            if (departureToDestMap.get(last).size() == 0) {
//                departureToDestMap.remove(last);
//            }
//            last = dest;
//        }
        dfs(tickets.length+1, list, "JFK", departureToDestMap);
        return list;
    }

    public boolean dfs(int N, List<String> list, String start, Map<String, List<String>> departureToDestMap) {
        if (departureToDestMap.get(start) == null || departureToDestMap.get(start).size() == 0) {
            if (list.size() == N) {
                return true;
            } else {
                return false;
            }
        }
        List<String> neighbours = departureToDestMap.get(start);
        for (int i=0; i<neighbours.size(); i++) {
            String neighbour=neighbours.get(i);
            list.add(neighbour);
            neighbours.remove(i);
            if (dfs(N, list, neighbour, departureToDestMap)) {
                return true;
            } else {
                list.remove(list.size()-1);
                neighbours.add(neighbour);
                Collections.sort(neighbours);
            }
        }
        return false;
    }
}