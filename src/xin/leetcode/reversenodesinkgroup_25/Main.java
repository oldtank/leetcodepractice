package xin.leetcode.reversenodesinkgroup_25;

/**
 * Created by Xin on 10/6/2016.
 */
public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=null;

        Solution s = new Solution();
        ListNode head = s.reverseKGroup(n1, 2);
        print(head);
    }

    static void print(ListNode curr) {
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
