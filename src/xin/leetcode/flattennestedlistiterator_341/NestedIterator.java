package xin.leetcode.flattennestedlistiterator_341;

import java.util.*;

/**
 * Created by Xin on 9/4/2016.
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> list;
    int currIndex;
    Stack<NestedInteger> stack;
    Queue<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = nestedList;
        currIndex = 0;
        stack = new Stack<>();
        queue = new ArrayDeque<>();
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    private void expandStack() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                queue.offer(stack.pop().getInteger());
            } else {
                List<NestedInteger> nestedList = stack.pop().getList();
                for (int i=nestedList.size()-1; i>=0; i--) {
                    stack.push(nestedList.get(i));
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        if (!queue.isEmpty()) {
            return true;
        } else {
            if (currIndex == list.size()) {
                return false;
            } else {
                if (list.get(currIndex).isInteger()) {
                    queue.offer(list.get(currIndex).getInteger());
                } else {
                    List<NestedInteger> nested = list.get(currIndex).getList();
                    for (int i=nested.size()-1; i>=0; i--) {
                        stack.push(nested.get(i));
                    }
                    expandStack();
                }
                currIndex++;
                return hasNext();
            }
        }
    }
}