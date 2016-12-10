package xin.datastructure;

import xin.general.GeneralUtil;

/**
 * Created by Xin on 7/20/2016.
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(10);
        try {
            queue.enqueue(GeneralUtil.generateRandomInt(100));
            queue.enqueue(GeneralUtil.generateRandomInt(100));
            queue.enqueue(GeneralUtil.generateRandomInt(100));
            queue.enqueue(GeneralUtil.generateRandomInt(100));
            queue.enqueue(GeneralUtil.generateRandomInt(100));
            queue.enqueue(GeneralUtil.generateRandomInt(100));
            queue.enqueue(GeneralUtil.generateRandomInt(100));
            queue.enqueue(GeneralUtil.generateRandomInt(100));
            queue.enqueue(GeneralUtil.generateRandomInt(100));
            queue.enqueue(GeneralUtil.generateRandomInt(100));
            queue.printAll();
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            queue.enqueue(GeneralUtil.generateRandomInt(100));
            queue.printAll();
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            queue.printAll();
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            queue.printAll();
            System.out.println(queue.dequeue());
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
