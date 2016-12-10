package xin.datastructure.linkedlist;

/**
 * Created by Xin on 7/20/2016.
 */
public class DoubleLinkedList<T> {
    private Element head;
    private Element tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public void insert(Element x) {
        x.setNext(head);
        if (head != null) {
            head.setPrev(x);
        } else {
            tail = x;
        }
        head = x;
        head.setPrev(null);
    }

    public Element search(T key) {
        Element curr = head;
        while (curr != null && curr.getKey() != key) {
            curr = curr.getNext();
        }
        return curr;
    }

    public void delete(Element e) {
        if (e.getPrev() == null) {
            head = e.getNext();
        } else {
            e.getPrev().setNext(e.getNext());
        }
        if (e.getNext() != null) {
            e.getNext().setPrev(e.getPrev());
        }
    }

    public void reverse() {
        if (head == null || head == tail) {
            return;
        }

        Element tmp = head;
        head = tail;
        tail = tmp;

        Element curr = head;
        while (curr != null) {
            Element temp = curr.getNext();
            curr.setNext(curr.getPrev());
            curr.setPrev(temp);
            curr = curr.getNext();
        }
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
