package xin.interview.dictionaryseparatestring;

/**
 * Created by Xin on 8/9/2016.
 */
public class Main {
    public static void main(String[] args) {
        DictionaryTree dictionaryTree = new DictionaryTree();
        dictionaryTree.addWord("samsung");
        dictionaryTree.addWord("sam");
        dictionaryTree.addWord("mobile");

        System.out.println(dictionaryTree.findWord("samsung"));
        System.out.println(dictionaryTree.findWord("mobile"));
        System.out.println(dictionaryTree.findWord("sam"));
        System.out.println(dictionaryTree.findWord("mobileasdf"));
        System.out.println(dictionaryTree.findWord("mo"));
    }
}
