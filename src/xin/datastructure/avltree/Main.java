package xin.datastructure.avltree;

import java.util.Scanner;

/**
 * Created by Xin on 7/27/2016.
 */
public class Main {
    public static void main(String[] args) {
        AvlTree<Integer> tree = new AvlTree<>();
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<20; i++) {
            int input = Integer.parseInt(scanner.next());
            tree.insert(input);
            tree.printTree();
        }
    }
}
