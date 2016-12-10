package xin.leetcode.partitionlist_86;

/**
 * Created by Xin on 8/28/2016.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head== null) {
            return null;
        }
        ListNode lastOfSmall = null, firstOfLarge = null, lastOfLarge = null;
        if (head.val < x) {
            lastOfSmall = head;
        } else {
            firstOfLarge = head;
            lastOfLarge = head;
        }
        ListNode walker = head.next, prev = head;
        while(walker != null) {
            ListNode next = walker.next;
            if (walker.val < x) {
                if (lastOfSmall == null) {
                    lastOfSmall = walker;
                    head = lastOfSmall;
                } else {
                    lastOfSmall.next = walker;
                    lastOfSmall = walker;
                }
                if (firstOfLarge != null) {
                    walker.next = firstOfLarge;
                    lastOfLarge.next = next;
                }
            } else {
                if (firstOfLarge == null) {
                    firstOfLarge = walker;
                    lastOfLarge = walker;
                } else {
                    lastOfLarge = walker;
                }
            }
            walker = next;
        }
        return head;
    }
}
