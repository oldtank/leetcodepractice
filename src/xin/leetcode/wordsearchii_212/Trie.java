package xin.leetcode.wordsearchii_212;

/**
 * Created by Xin on 9/25/2016.
 */
public class Trie {
    TrieNode root;

    public Trie() {
        root= new TrieNode();
    }

    public void insertWord(String word) {
        TrieNode curr = root;

        for (int i=0; i<word.length(); i++) {
            if (curr.nexts[word.charAt(i) - 'a'] == null) {
                curr.nexts[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.nexts[word.charAt(i) - 'a'];
        }
        curr.isLeaf = true;
    }

    public static enum Result {
        MATCH,
        PREFIX_MATCH,
        NOMATCH
    }

    public Result search(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            if (curr.nexts[word.charAt(i) - 'a'] == null) {
                return Result.NOMATCH;
            }
            curr = curr.nexts[word.charAt(i) - 'a'];
        }
        if (curr.isLeaf) {
            return Result.MATCH;
        } else {
            return Result.PREFIX_MATCH;
        }
    }

    public TrieNode search(Character c, TrieNode from) {
        if (from == null) {
            return null;
        }
        return from.nexts[c-'a'];
    }
}
