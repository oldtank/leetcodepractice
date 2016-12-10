package xin.leetcode.reverselinkedlist_206;

/**
 * Created by Xin on 10/5/2016.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head ==null || head.next == null) {
            return head;
        }
        return reverseRecursive(head);
    }

    ListNode reverseRecursive(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverseRecursive(head.next);
        if (head.next != null) {
            head.next.next = head;
        }
        head.next = null;
        return newHead;
    }

    ListNode reverseIte(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null, curr = head, next = curr.next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
