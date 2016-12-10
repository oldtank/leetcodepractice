package xin.leetcode.palindromelinkedlist_234;

/**
 * Created by Xin on 11/24/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] values = {1,2,3,3,2,1};
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i=1; i<values.length; i++) {
            ListNode newNode = new ListNode(values[i]);
            curr.next = newNode;
            curr = newNode;
        }
        System.out.println(new Solution().isPalindrome(head));
    }
}
