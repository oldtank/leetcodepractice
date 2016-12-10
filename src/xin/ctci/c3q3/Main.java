package xin.ctci.c3q3;

/**
 * Created by Xin on 8/21/2016.
 */
public class Main {
    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks(3);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
//        System.out.println(stacks.pop());

    }
}
