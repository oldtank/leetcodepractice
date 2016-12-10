package xin.leetcode.addandsearchword_211;

/**
 * Created by Xin on 11/18/2016.
 */
public class TrieNode {
    public boolean isLeaf;
    public TrieNode[] nextChars;

    public TrieNode() {
        isLeaf = false;
        nextChars = new TrieNode[26];
        for (int i=0; i<26; i++) {
            nextChars[i] = null;
        }
    }
}
