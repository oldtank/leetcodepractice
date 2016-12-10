package xin.interview.linkedlist;

/**
 * Created by Xin on 11/18/2016.
 */
public class SimpleLinkedList {
    Node head;

    public SimpleLinkedList() {
        head = null;
    }

    public Node getNth(int n) {
        Node node = head;
        for (int i=0; i<n; i++) {
            node = node.getNext();
        }
        return node;
    }

    public void add(int i) {
        Node n = new Node(i);
        n.next = head;
        head = n;
    }

    public void reverse(Node from, Node to) {
        Node dummy = new Node(-1);
        dummy.setNext(head);
        Node prev = dummy;
        for (; prev != null; prev = prev.getNext()) {
            if (prev.getNext() == from) {
                break;
            }
        }

        Node curr = from, next = curr.getNext();
        while (prev.getNext() != to) {
            Node tmp = next.getNext();
            next.setNext(prev.getNext());
            prev.setNext(next);
            curr.setNext(tmp);
            next = tmp;
        }

        head = dummy.getNext();
    }

    public void print() {
        for (Node runner = head; runner != null; runner=runner.getNext()) {
            System.out.print(runner.getValue() + " ");
        }
        System.out.println();
    }
}
