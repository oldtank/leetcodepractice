package xin.ctci.c2q7;

import lombok.Data;

import java.util.Stack;

/**
 * Created by Xin on 8/21/2016.
 */
@Data
public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(Node n) {
        n.setNext(head);
        head = n;
    }

    public boolean isPalindrom() {
        if (head == null || head.getNext() == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        Node slow = head, fast = head;
        while(fast != null) {
            fast = fast.getNext();
            if (fast != null) {
                stack.push(slow.getValue());
                fast = fast.getNext();
            }

            slow = slow.getNext();
        }
        Node secondHalf = slow;
        while (secondHalf != null) {
            if (stack.pop() != secondHalf.getValue()) {
                return false;
            }
            secondHalf = secondHalf.getNext();
        }
        return true;
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.getValue() + " ");
        }
        System.out.println();
    }
}
