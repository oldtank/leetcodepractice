package xin.leetcode.mergeksortedlists_23;

import java.util.Random;

/**
 * Created by Xin on 8/26/2016.
 */
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        ListNode head1 = new ListNode(rand.nextInt(5));
        ListNode head2 = new ListNode(rand.nextInt(5));
        ListNode head3 = new ListNode(rand.nextInt(5));

        ListNode curr1=head1;
        ListNode curr2=head2;
        ListNode curr3=head3;
        for (int i=0; i<5; i++) {
            curr1.next = new ListNode(rand.nextInt(5) + curr1.val);
            curr2.next = new ListNode(rand.nextInt(5) + curr2.val);
            curr3.next = new ListNode(rand.nextInt(5) + curr3.val);
            curr1 = curr1.next;
            curr2 = curr2.next;
            curr3 = curr3.next;
        }
        print(head1);
        print(head2);
        print(head3);
        ListNode lists[] = {head1, head2, head3};
        print(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int left = 0, right = lists.length-1;
        while(left<right) {
            int l = left, r = right;
            while (l < r) {
                lists[l] = merge2(lists[l], lists[r]);
                l++;
                r--;
            }
            if (l==r) {
                right = l;
            } else {
                right = l-1;
            }
        }
        return lists[0];
    }

    public static ListNode merge2(ListNode l1, ListNode l2) {
        if (l1 == l2) {
            return l1;
        }
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else {
            if (l1.val <= l2.val) {
                l1.next = merge2(l1.next, l2);
                return l1;
            } else {
                l2.next = merge2(l1, l2.next);
                return l2;
            }
        }
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
