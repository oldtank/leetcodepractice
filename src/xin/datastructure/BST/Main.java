package xin.datastructure.BST;

import java.util.Scanner;

/**
 * Created by Xin on 7/23/2016.
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        System.out.println((int) '└');
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i<10; i++) {
            int input = Integer.parseInt(scanner.next());
            bst.insert_iterative(new Element(input));
            bst.inOrder(bst.getRoot());
            System.out.println();
            bst.printPrettyTree(bst.getRoot());
        }
    }
}
