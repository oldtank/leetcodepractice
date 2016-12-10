package xin.datastructure.linkedlist;

/**
 * Created by Xin on 7/20/2016.
 */
public class Element<T> {
    private Element prev;
    private Element next;
    private T key;

    public Element(T key) {
        prev = null;
        next = null;
        this.key = key;
    }

    public Element getPrev() {
        return prev;
    }

    public void setPrev(Element prev) {
        this.prev = prev;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next)  {
        this.next = next;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
