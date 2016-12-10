package xin.leetcode.palindromelinkedlist_234;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
       while (fast.next != null && fast.next.next != null) {
           slow = slow.next;
           fast = fast.next.next;
       }
        if (fast.next == null) {
            ListNode secondHalf = slow.next;
            System.out.println(String.format("reversing %d to %d", head.val, slow.val));
            ListNode firstHalf = reverse(head, slow);
            print(firstHalf);
            return compare(firstHalf.next, secondHalf);
        } else {
            ListNode secondHalf = slow.next;
            System.out.println(String.format("reversing %d to %d", head.val, slow.val));
            ListNode firstHalf = reverse(head, slow);
            print(firstHalf);
            return compare(firstHalf, secondHalf);
        }
    }

    private void print(ListNode n) {
        while (n != null) {
            System.out.print(n.val+" ");
            n = n.next;
        }
        System.out.println();
    }

    private boolean compare(ListNode l1, ListNode l2) {
        ListNode stop = l2;
        while (l1 != stop) {
            if (l1.val != l2.val) {
                return false;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return true;
    }

    private ListNode reverse(ListNode head, ListNode end) {
        ListNode fake = new ListNode(0);
        fake.next = head;

        ListNode prev = fake, curr = head, next = curr.next;
        ListNode stop = end.next;
        while (next != stop) {
            ListNode tmp = next.next;
            next.next = prev.next;
            prev.next = next;
            curr.next = tmp;
            next = tmp;
        }

        return prev.next;
    }
}