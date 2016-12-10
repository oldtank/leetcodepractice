package xin.leetcode.flatten2dvector_251;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * Created by Xin on 9/5/2016.
 */
public class Vector2D implements Iterator<Integer> {
    List<List<Integer>> vec2d;
    Queue<Integer> queue;
    int i;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        queue = new ArrayDeque<>();
        i= 0;
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        if (!queue.isEmpty()) {
            return true;
        } else {
            if (i==vec2d.size()) {
                return false;
            } else {
                for (int x=0; x<vec2d.get(i).size();x++) {
                    queue.offer(vec2d.get(i).get(x));
                }
                i++;
                return hasNext();
            }
        }
    }
}
