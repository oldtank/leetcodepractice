package xin.ctci.c3q6;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Xin on 8/21/2016.
 */
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.push(4);
        stack.push(8);
        System.out.println(sort(stack));
    }

    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> r = new Stack<>();
        while(!stack.isEmpty()) {
            int tmp = stack.pop();
            while(!r.isEmpty() && r.peek() > tmp) {
                stack.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }
}
