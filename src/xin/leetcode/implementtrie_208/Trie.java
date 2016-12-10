package xin.leetcode.implementtrie_208;

/**
 * Created by Xin on 9/4/2016.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            if (curr.getLinked()[word.charAt(i)-'a'] == null) {
                curr.getLinked()[word.charAt(i)-'a'] = new TrieNode();
            }
            curr = curr.getLinked()[word.charAt(i)-'a'];
            if (i == word.length()-1) {
                curr.setLeaf(true);
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int i=0;
        TrieNode curr = root;
        while (curr != null && i<word.length()) {
            curr = curr.getLinked()[(word.charAt(i)-'a')];
            if (i==word.length()-1 && curr != null &&  curr.isLeaf()) {
                return true;
            }
            i++;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        int i=0;
        TrieNode curr = root;
        while (curr != null && i< prefix.length()) {
            curr = curr.getLinked()[prefix.charAt(i)-'a'];
            if (curr != null && i==prefix.length()-1) {
                return true;
            }
            i++;
        }
        return false;
    }
}