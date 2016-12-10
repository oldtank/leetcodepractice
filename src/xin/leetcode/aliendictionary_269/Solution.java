package xin.leetcode.aliendictionary_269;

import xin.graph.VisitStatus;

import java.util.*;

/**
 * Created by Xin on 9/18/2016.
 */
public class Solution {
    public String alienOrder(String[] words) {
        Set<Character> alpha = new HashSet<>();
        Map<Character, List<Character>> map = new HashMap<>();
        for (int i=0; i< words.length; i++) {
            for (int j=0; j<words[i].length(); j++) {
                alpha.add(words[i].charAt(j));
            }
        }
        for (int i=0; i< words.length-1; i++) {
            if (words[i+1].indexOf(words[i]) ==0) {
                continue;
            }

            for (int j=0; j<words[i].length() && j<words[i+1].length(); j++) {
                if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    map.putIfAbsent(words[i].charAt(j), new ArrayList<>());
                    System.out.println("adding "+words[i].charAt(j)+":"+words[i+1].charAt(j)+" to tree");
                    map.get(words[i].charAt(j)).add(words[i+1].charAt(j));
                    break;
                }
            }
        }

        Map<Character, VisitStatus> visitStatus = new HashMap<>();
        LinkedList<Character> list = new LinkedList<>();
        boolean success = true;
        for(Character c : alpha) {
            if (visitStatus.get(c) == null) {
                System.out.println("checking " + c);
                success = success && topsort(map, c, visitStatus, list);
            }
        }

        if (success) {
            StringBuilder sb = new StringBuilder();
            Collections.reverse(list);
            list.forEach(c -> sb.append(c));
            return sb.toString();
        } else {
            System.out.println("failed");
            return "";
        }
    }

    public boolean topsort(Map<Character, List<Character>> tree, Character root, Map<Character, VisitStatus> visitStatus, LinkedList<Character> list) {
        boolean success = true;
        if (tree.get(root)!=null) {
            for (Character c : tree.get(root)) {
                if (visitStatus.get(c) != null) {
                    if (visitStatus.get(c) == VisitStatus.Discovered) {
                        return false;
                    } else if (visitStatus.get(c) == VisitStatus.Completed) {
                    }
                } else {
                    if (!visitStatus.containsKey(c)) {
                        visitStatus.put(c, VisitStatus.Discovered);
                        success = (success && topsort(tree, c, visitStatus, list));
                    }
                }
            }
        }
        visitStatus.put(root, VisitStatus.Completed);
        list.addLast(root);
        return success;
    }

    enum VisitStatus {
        Discovered,
        Completed
    }
}