package xin.ctci.c3q3;

import lombok.Data;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Xin on 8/21/2016.
 */
@Data
public class SetOfStacks {
    private int capacity;
    private ArrayList<Stack<Integer>> stacks;
    private int currentStack;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
        currentStack = -1;
    }

    public void push(int i) {
        if (currentStack < 0) {
            stacks.add(new Stack<>());
            currentStack = 0;
        }
        if (stacks.get(currentStack).size() < capacity) {
            stacks.get(currentStack).push(i);
        } else {
            currentStack += 1;
            stacks.add(new Stack<>());
            stacks.get(currentStack).push(i);
        }
    }

    public int pop() {
        if (currentStack < 0 ) {
            throw new RuntimeException("stack is now empty");
        }

        int item = stacks.get(currentStack).pop();
        if (stacks.get(currentStack).size() == 0) {
            stacks.remove(currentStack);
            currentStack --;
        }
        return item;
    }
}
