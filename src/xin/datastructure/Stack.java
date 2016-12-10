package xin.datastructure;

import java.util.ArrayList;

/**
 * Created by Xin on 7/20/2016.
 */
public class Stack<T extends Comparable> {
    private ArrayList<T> list;
    private int top;

    public Stack() {
        list = new ArrayList<>();
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(T value) {
        list.add(value);
        top++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        } else {
            top--;
            return list.get(top);
        }
    }
}
