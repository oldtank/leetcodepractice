package xin.leetcode.addandsearchword_211;

/**
 * Created by Xin on 11/18/2016.
 */
public class Main {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search("..d"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("..e"));
    }
}
