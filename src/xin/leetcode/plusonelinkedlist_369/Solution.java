package xin.leetcode.plusonelinkedlist_369;

/**
 * Created by Xin on 9/5/2016.
 */
public class Solution {

    public void printNumber(ListNode head) {
        ListNode curr = head;
        while(curr!=null) {
            System.out.print(curr.val);
            curr = curr.next;
        }
    }

    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }
        int carry = helper(head, 1);
        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        } else {
            return head;
        }
    }

    public int helper(ListNode head, int carry) {
        if (head.next == null) {
            int new_val = (head.val+1)%10;
            int new_carry = (head.val+1)/10;
            head.val = new_val;
            return new_carry;
        }
        int carry_from_sub = helper(head.next, carry);
        int new_val = (head.val+carry_from_sub)%10;
        int new_carry = (head.val+carry_from_sub)/10;
        head.val = new_val;
        return new_carry;
    }
}