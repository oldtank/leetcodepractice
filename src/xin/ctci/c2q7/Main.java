package xin.ctci.c2q7;

/**
 * Created by Xin on 8/21/2016.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(3));
        list.add(new Node(1));
        System.out.println(list.isPalindrom());
    }
}
