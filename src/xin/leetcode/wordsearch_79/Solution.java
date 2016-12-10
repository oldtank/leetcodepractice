package xin.leetcode.wordsearch_79;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xin on 8/27/2016.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean visited[][] = new boolean[board.length][board[0].length];
                    visited[i][j]=true;
                    if (existHelper(board, word, 1, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean existHelper(char[][] board, String word, int pos, int curr_i, int curr_j, boolean[][] visited) {
        if (pos==word.length()) {
            return true;
        }

        Position connected[] = {new Position(curr_i-1, curr_j), new Position(curr_i, curr_j-1),
                                new Position(curr_i, curr_j+1), new Position(curr_i+1, curr_j)};

        for (Position position : connected) {
            if (position.isValid(board.length-1, board[0].length-1)) {
                if (!visited[position.i][position.j]
                        && board[position.i][position.j] == word.charAt(pos)) {
                    visited[position.i][position.j] = true;
                    if (existHelper(board, word, pos+1, position.i, position.j, visited)) {
                        return true;
                    } else {
                        visited[position.i][position.j] = false;
                    }
                }
            }
        }
        return false;
    }


    public class Position {
        int i;
        int j;

        Position(int i, int j) {
            this.i=i;
            this.j=j;
        }
        boolean isValid(int max_i, int max_j) {
            return i<=max_i && j<=max_j && i>=0 && j>=0;
        }
        String encode() {
            return i+"+"+j;
        }
    }
}
