package xin.leetcode.removeduplicatesfromsortedlist_82;

/**
 * Created by Xin on 8/28/2016.
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, curr = head;
        while(curr != null && curr.next != null) {
            if (curr.val != curr.next.val) {
                prev = curr;
                curr = curr.next;
            } else {
                ListNode walker = curr.next;
                while (walker != null && walker.val == curr.val) {
                    walker = walker.next;
                }
                if (prev == null) {
                    head = walker;
                    curr = walker;
                } else {
                    prev.next = walker;
                    curr = walker;
                }
            }
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            ListNode walker = head.next;
            while (walker != null && head.val == walker.val) {
                walker = walker.next;
            }
            head = walker;
            return deleteDuplicates1(head);
        } else {
            head.next = deleteDuplicates1(head.next);
        }
        return head;
    }
}
