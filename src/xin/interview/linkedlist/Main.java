package xin.interview.linkedlist;

import java.util.Random;

/**
 * Created by Xin on 11/18/2016.
 */
public class Main {
    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();

        Random rand = new Random();
        for (int i=0; i<10; i++) {
            list.add(rand.nextInt(20));
        }

        list.print();
        int start = rand.nextInt(5);
        int end = rand.nextInt(5) + 5;
        Node startNode = list.getNth(start);
        Node endNode = list.getNth(end);
        System.out.println(String.format("reversing pos %d:%d to %d:%d", start, startNode.getValue(),
                end, endNode.getValue()));
        list.reverse(startNode, endNode);
        list.print();

    }
}
