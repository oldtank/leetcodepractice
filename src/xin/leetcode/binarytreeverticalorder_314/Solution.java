package xin.leetcode.binarytreeverticalorder_314;

import java.util.*;

/**
 * Created by Xin on 9/7/2016.
 */
public class Solution {
    class IndexedNumber {
        int index;
        TreeNode node;
        public IndexedNumber(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Map<Integer, List<Integer>> indexedList = new TreeMap<>();
        Queue<IndexedNumber> queue = new ArrayDeque<>();
        queue.offer(new IndexedNumber(0, root));
        while (!queue.isEmpty()) {
            IndexedNumber curr = queue.poll();
            indexedList.putIfAbsent(curr.index, new ArrayList<>());
            indexedList.get(curr.index).add(curr.node.val);

            if (curr.node.left != null) {
                queue.offer(new IndexedNumber(curr.index-1, curr.node.left));
            }
            if (curr.node.right != null) {
                queue.offer(new IndexedNumber(curr.index+1, curr.node.right));
            }
        }

        for (Integer index : indexedList.keySet()) {
            lists.add(indexedList.get(index));
        }
        return lists;
    }
}