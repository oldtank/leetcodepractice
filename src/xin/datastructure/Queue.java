package xin.datastructure;

import java.util.ArrayList;

/**
 * Created by Xin on 7/20/2016.
 */
public class Queue<T extends Comparable> {
    private ArrayList<T> list;
    private int head;
    private int tail;
    private int capacity;
    private int indexBound;

    public Queue(int capacity) {
        list = new ArrayList<>();
        for (int i=0; i<=capacity; i++) {
            list.add(null);
        }
        head = 0;
        tail = 0;
        this.capacity = capacity;
        this.indexBound = capacity + 1;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return ((tail + 1) % indexBound == head);
    }

    public void enqueue(T value) {
        if (!isFull()) {
            list.set(tail, value);
            tail = (tail + 1) % indexBound;
        } else {
            throw new RuntimeException("Queue is full");
        }
    }

    public T dequeue() {
        if (!isEmpty()) {
            T value = list.get(head);
            head = (head+1) % indexBound;
            return value;
        } else {
            throw new RuntimeException("Queue is empty");
        }
    }

    public void printAll() {
        StringBuilder builder = new StringBuilder();
        if (!isEmpty()) {
            for (int i=head; i != tail; i=(i+1)%indexBound) {
                builder.append(list.get(i)+ " ");
            }
            System.out.println(builder.toString());
        } else {
            System.out.println("Queue empty");
        }

    }
}
