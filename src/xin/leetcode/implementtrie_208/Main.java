package xin.leetcode.implementtrie_208;

/**
 * Created by Xin on 9/4/2016.
 */
public class Main {
    public static void main(String[] args) {
        Trie  t = new Trie();
        t.insert("somestring");
        t.insert("something");
        System.out.println(t.search("something"));
        System.out.println(t.search("somethinge"));
    }
}
