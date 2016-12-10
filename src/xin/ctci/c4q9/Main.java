package xin.ctci.c4q9;

import java.util.List;
import java.util.Random;

/**
 * Created by Xin on 8/22/2016.
 */
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Random rand = new Random();
        for (int i=0; i<20; i++) {
            tree.insertBinary(rand.nextInt(40));
        }
        tree.inOrderPrint(tree.getRoot());
        System.out.println();
        tree.printPaths();
        System.out.print("serialize: ");
        printList(tree.serialize());
        Tree tree1 = new Tree();
        tree1.deserialize(tree.serialize());
        tree1.printPaths();

        System.out.println("find path");
        tree.findPathofSum(30);
    }

    public static void printList(List<Integer> list) {
        list.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
