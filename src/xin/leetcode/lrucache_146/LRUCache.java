package xin.leetcode.lrucache_146;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xin on 9/7/2016.
 */
public class LRUCache {
    int capacity;
    int size;
    Map<Integer, DoubleLinkedListNode> map;
    DoubleLinkedListNode head;
    DoubleLinkedListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size=0;
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        DoubleLinkedListNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToTail(node);
            return node.val;
        }
    }

    public void set(int key, int value) {
        DoubleLinkedListNode node = map.get(key);
        if (node == null) {
            DoubleLinkedListNode n = new DoubleLinkedListNode(key, value);
            map.put(key, n);
            addToList(key, n);
            return;
        } else {
            node.val = value;
            moveToTail(node);
        }
    }

    public void addToList(int key, DoubleLinkedListNode node) {
        if (head == tail && head == null) {
            head = node;
            tail = node;
            size++;
            return;
        } else {
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
            if (size == capacity) {
                map.remove(head.key);
                head = head.next;
                head.prev = null;
            } else {
                size++;
            }
        }
    }

    public void moveToTail(DoubleLinkedListNode node) {
        if (tail == node) {
            return;
        }
        if (node == head) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next!=null) {
            node.next.prev = node.prev;
        }
        tail.next = node;
        node.next = null;
        node.prev = tail;
        tail = node;
    }

    class DoubleLinkedListNode {
        int val;
        int key;
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;
        public DoubleLinkedListNode(int key, int val) {
            this.val= val;
            this.key = key;
            prev = null;
            next = null;
        }
    }

    public void printList() {
        DoubleLinkedListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}