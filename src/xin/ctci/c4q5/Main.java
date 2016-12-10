package xin.ctci.c4q5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Xin on 8/22/2016.
 */
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Random rand = new Random();
        for (int i=0; i<10; i++) {
            tree.insertBinary(rand.nextInt(50));
        }
        tree.inOrderPrint(tree.getRoot());
        System.out.println();
        ArrayList<Integer> list = tree.inOrderArray(tree.getRoot());
        printList(list);
        System.out.println(tree.isBST());
    }

    public static void printList(List<Integer> list) {
        list.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
