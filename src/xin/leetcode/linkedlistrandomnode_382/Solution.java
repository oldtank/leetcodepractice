package xin.leetcode.linkedlistrandomnode_382;

import java.util.Random;

/**
 * Created by Xin on 9/6/2016.
 */
public class Solution {
    ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode curr = head.next;
        int index=2, result = head.val;
        Random random = new Random();
        while (curr != null) {
            if (random.nextDouble() < 1.0/index) {
                result = curr.val;
            }
            index++;
            curr = curr.next;
        }
        return result;
    }
}