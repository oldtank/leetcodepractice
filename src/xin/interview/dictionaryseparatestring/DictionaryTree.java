package xin.interview.dictionaryseparatestring;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by Xin on 8/9/2016.
 */
@Data
public class DictionaryTree {
    Node root;

    public DictionaryTree() {
        root = new Node();
    }

    public Node findWord(String word) {
        return findWord(root, word, 0);
    }

    private Node findWord(Node root, String word, int curr_pos) {
        if (curr_pos == word.length()) {
            return root;
        }
        if (root.getNextChar().get(word.charAt(curr_pos)) == null) {
            return null;
        } else {
            return findWord(root.getNextChar().get(word.charAt(curr_pos)), word, curr_pos+1);
        }
    }

    public void addWord(String word) {
        addWord(root, word, 0);
    }
    private void addWord(Node root, String word, int curr_pos) {
        if (curr_pos == word.length()) {
            root.setLeaf(true);
            return;
        }
        if (root.getNextChar().get(word.charAt(curr_pos)) == null) {
            Node next = new Node();
            root.getNextChar().put(word.charAt(curr_pos), next);
        }
        addWord(root.getNextChar().get(word.charAt(curr_pos)), word, curr_pos+1);
    }

    public void deleteWord(String word) {

    }
}
