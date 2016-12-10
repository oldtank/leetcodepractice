package xin.leetcode.lrucache_146;

/**
 * Created by Xin on 9/7/2016.
 */
public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.set(1,1);
        cache.printList();
        cache.set(2,2);
        cache.printList();
        cache.set(3,3);
        cache.printList();
        cache.set(4,4);
        cache.printList();
        cache.get(4);
        cache.printList();
        cache.get(3);
        cache.printList();
        cache.get(2);
        cache.printList();
        cache.get(1);
        cache.printList();
        cache.set(5,5);
        cache.printList();
        cache.get(1);
        cache.printList();
        cache.get(2);
        cache.printList();
        cache.get(3);
        cache.printList();
        cache.get(4);
        cache.printList();
        cache.get(5);
        cache.printList();
    }
}
