package xin.leetcode.addandsearchword_211;

/**
 * Created by Xin on 11/18/2016.
 */
public class Trie {
    TrieNode root = new TrieNode();
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i =0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (curr.nextChars[c - 'a'] == null) {
                curr.nextChars[c - 'a'] = new TrieNode();
            }
            curr = curr.nextChars[c - 'a'];
        }
        curr.isLeaf = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    public boolean searchHelper(TrieNode startNode, String word, int pos) {
        if (startNode == null) {
            return false;
        }
        if (pos == word.length()) {
            if (startNode != null && startNode.isLeaf) {
                return true;
            } else {
                return false;
            }
        }

        char c = word.charAt(pos);
        if (c != '.') {
            return searchHelper(startNode.nextChars[c - 'a'], word, pos+1);
        } else {
            for (int i=0; i<26; i++) {
                if (startNode.nextChars[i] != null) {
                    if (searchHelper(startNode.nextChars[i], word, pos+1)) {
                        return true;
                    } else {
                        continue;
                    }
                }
            }
            return false;
        }
    }
}
