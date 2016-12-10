package xin.datastructure.linkedlist;

/**
 * Created by Xin on 7/21/2016.
 */
public class LinkedList<T> {
    private Element head;

    public LinkedList() {
        head = null;
    }

    public void insert(Element e) {
        e.setNext(head);
        head = e;
    }

    public void delete(Element e) {
        if (e == head) {
            head = head.getNext();
        } else {
            Element prev = head;
            while (prev.getNext() != e) {
                prev = prev.getNext();
            }
            prev.setNext(e.getNext());
        }
    }

    public void reverse() {
        if (head == null || head.getNext() == null) {
            return;
        }
        Element curr = head, prev = null, next;
        while(curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void reverse_recursive() {
        head = reverse_recursive(head);
    }

    public Element reverse_recursive(Element e) {
        if (e == null) {
            return null;
        }
        if (e.getNext() == null) {
            return e;
        }

        Element newHead = reverse_recursive(e.getNext());
        e.getNext().setNext(e);
        e.setNext(null);
        return newHead;
    }

    public void printAll() {
        Element curr = head;
        while (curr != null) {
            System.out.print(curr.getKey() + " ");
            curr = curr.getNext();
        }
        System.out.print("\n");
    }
}
