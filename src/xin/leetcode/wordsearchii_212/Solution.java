package xin.leetcode.wordsearchii_212;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 9/25/2016.
 */
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0 ) {
            return list;
        }

        Trie t = new Trie();
        for (int i=0; i<words.length; i++) {
            t.insertWord(words[i]);
        }
        int m=board.length;
        int n = board[0].length;
        TrieNode tmp = t.search('e', t.root);
        TrieNode tmp1 = t.search('o', tmp);
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (t.search(""+board[i][j]) == Trie.Result.MATCH) {
                    list.add("" + board[i][j]);
                }
                if (t.search("" + board[i][j]) == Trie.Result.PREFIX_MATCH) {
                    boolean visited[][] = new boolean[m][n];
                    visited[i][j] = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append(board[i][j]);
                    dfs(board, t, t.search(board[i][j], t.root), sb, i, j, list, visited);
                }
            }
        }

        return list;
    }

    public void dfs(char[][] board, Trie t, TrieNode currNode, StringBuilder sb, int curri, int currj, List<String> list, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;

        if (currNode.isLeaf) {
            list.add(sb.toString());
        }

        int neighbours[][] = {{curri, currj-1}, {curri, currj+1}, {curri-1, currj}, {curri+1, currj}};

        for (int[] neighbour : neighbours) {
            int i = neighbour[0];
            int j = neighbour[1];
            if (isValid(i,j, m, n) && !visited[i][j]) {
                TrieNode nextNode = t.search(board[i][j], currNode);
                if (nextNode != null) {
                    visited[i][j] = true;
//                    System.out.println("checking " + board[i][j] + ", neighbour of " + board[curri][currj]);
                    sb.append(board[i][j]);
                    currNode = nextNode;
                    dfs(board, t, nextNode, sb, i, j, list, visited);

//                    visited[i][j] = false;
//
//                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        visited[curri][currj] = false;
        sb.deleteCharAt(sb.length()-1);
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i>=0 && i<m && j>=0 && j<n;
    }
}