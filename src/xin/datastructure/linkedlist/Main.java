package xin.datastructure.linkedlist;

import xin.general.GeneralUtil;

/**
 * Created by Xin on 7/20/2016.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=0; i<20; i++) {
            linkedList.insert(new Element(GeneralUtil.generateRandomInt(21)));
        }
        linkedList.printAll();
        linkedList.reverse_recursive();
        linkedList.printAll();

        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        for (int i=0; i<20; i++) {
            doubleLinkedList.insert(new Element(GeneralUtil.generateRandomInt(21)));
        }
        doubleLinkedList.printAll();
        doubleLinkedList.reverse();
        doubleLinkedList.printAll();
    }
}
