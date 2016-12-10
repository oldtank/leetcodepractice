package xin.leetcode.reversenodesinkgroup_25;

/**
 * Created by Xin on 10/6/2016.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = head;
        ListNode start = head;
        ListNode end;

        ListNode prev = null;
        while (start != null) {
            end = start;
            int i=0;
            while (end != null && i<k-1) {
                end = end.next;
                i++;
            }
            if (end == null) {
                break;
            }
            ListNode tmp = end.next;
//            System.out.println("reversing " + start.val+" to "+end.val);
            ListNode newSubHead = reverseHelper(start, end);
            if (prev == null) {
                newHead = newSubHead;
            } else {
                prev.next = newSubHead;
            }
            prev = start;
            start = tmp;
        }
        return newHead;
    }

    ListNode reverseHelper(ListNode start, ListNode end) {
        if (start == end) {
            return start;
        }

        ListNode curr = start, next = start.next;
        ListNode following = end.next;
        while (curr != end) {
            ListNode tmp = next.next;
            next.next = curr;
            curr = next;
            next = tmp;
        }
        start.next = following;
        return end;
    }
}