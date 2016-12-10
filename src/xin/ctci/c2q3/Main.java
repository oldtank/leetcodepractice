package xin.ctci.c2q3;

import java.util.Random;

/**
 * Created by Xin on 8/20/2016.
 */
public class Main {
    public static void main(String[] args) {
        Node head = initialize(10);
        print(head);
        Node toRemove = find(head, 5);
        remove(toRemove);
        print(head);
    }

    public static void remove(Node toRemove) {
        if (toRemove == null || toRemove.getNext() == null) {
            throw new RuntimeException("unable to remove");
        }
        Node next = toRemove.getNext();
        toRemove.setValue(next.getValue());
        toRemove.setNext(next.getNext());
    }

    public static Node find(Node head, int value) {
        if (head == null) {
            return null;
        }

        while (head != null) {
            if (head.getValue() == value) {
                return head;
            }
            head = head.getNext();
        }
        return head;
    }

    public static Node initialize(int size) {
        Node head = new Node(0);
        Node curr = head;
        for (int i=1;i<size; i++) {
            Node next = new Node(i);
            curr.setNext(next);
            curr = next;
        }
        return head;
    }

    public static void print(Node from) {
        while (from != null) {
            System.out.print(from.getValue() + " ");
            from = from.getNext();
        }
        System.out.println();
    }
}
