package xin.leetcode.wordsearchii_212;

/**
 * Created by Xin on 9/25/2016.
 */
public class TrieNode {
    boolean isLeaf;
    TrieNode nexts[];

    public TrieNode () {
        isLeaf = false;
        nexts = new TrieNode[26];
        for (int i=0; i<26; i++) {
            nexts[i] = null;
        }
    }
}
