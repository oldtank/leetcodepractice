package xin.leetcode.implementtrie_208;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/4/2016.
 */
public class TrieNode {
    private boolean isLeaf;
    private TrieNode[] linked;

    public boolean isLeaf() {
        return isLeaf;
    }
    public void setLeaf(boolean b) {
        isLeaf = b;
    }

    public TrieNode[] getLinked() {
        return linked;
    }
    public TrieNode() {
        this.isLeaf = false;
        linked = new TrieNode[26];
        for (int i=0; i<26; i++) {
            linked[i] = null;
        }
    }
}
