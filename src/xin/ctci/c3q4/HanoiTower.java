package xin.ctci.c3q4;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by Xin on 8/21/2016.
 */
public class HanoiTower {
    ArrayList<Stack<Integer>> towers;

    public HanoiTower(int size) {
        towers = new ArrayList<>();
        for (int i=0; i<3; i++) {
            towers.add(new Stack<>());
        }
        for (int i=size-1; i>=0; i--) {
            towers.get(0).push(i);
        }
    }

    public void move() {
        move(towers.get(0).size(), 0, 2, 1);
    }

    private void move(int num, int from, int to, int helper) {
        if (num == 0) {
            return;
        }
        move(num-1, from, helper, to);
        int item = towers.get(from).pop();
        towers.get(to).push(item);
        System.out.println("move plate " + item + " from tower " + from + " to tower " + to);
        move(num-1, helper, to, from);

    }
}
