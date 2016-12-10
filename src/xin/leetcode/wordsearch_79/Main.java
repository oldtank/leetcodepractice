package xin.leetcode.wordsearch_79;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

 https://leetcode.com/problems/word-search/
 */
public class Main {
    public static void main(String[] args) {
//        char[][] board = { {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}};
        char[][] board = {{'a','a'}};
        String word = "aaa";
        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));
    }
}
