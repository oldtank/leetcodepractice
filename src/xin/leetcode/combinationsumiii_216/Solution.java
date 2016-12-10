package xin.leetcode.combinationsumiii_216;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/6/2016.
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(k, n, new ArrayList<>(), result);
        return result;
    }

    public void helper(int k, int target, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == k) {
            if (target == 0) {
                result.add(curr);
                return;
            } else {
                return;
            }
        }

        int next = curr.size() == 0 ? 1 : curr.get(curr.size()-1)+1;
        while (next <= 9) {
            if (next > target) {
                break;
            }
            List<Integer> l = new ArrayList<>(curr);
            l.add(next);
//            System.out.println("added " + next + " looking for target " + (target - next));
            helper(k, target - next, l, result);
            next++;
        }
    }

    public List<List<Integer>> combinationSum3a(int k, int n) {
        List<Integer> parent = new ArrayList<>();
        return helpera(k, n,9, parent);
    }

    public List<List<Integer>> helpera(int k, int target, int max, List<Integer> parent) {
        if (k==0) {
            if (target==0) {
                List<Integer> list = new ArrayList<>();
                List<List<Integer>> lists = new ArrayList<>();
                lists.add(list);
                return lists;
            } else {
                return new ArrayList<>();
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int num=Math.min(target, max); num>=1; num--) {
            if (parent.contains(num)) {
                continue;
            }
            parent.add(num);
            List<List<Integer>> subLists = helpera(k-1, target-num, num-1, parent);
            if (!subLists.isEmpty()) {
                for (List<Integer> sub : subLists) {
                    List<Integer> list = new ArrayList<>();
                    list.addAll(sub);
                    list.add(num);
                    lists.add(list);
                }

            }
            parent.remove(parent.size()-1);
        }
        return lists;
    }
}