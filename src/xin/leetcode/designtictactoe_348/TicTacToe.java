package xin.leetcode.designtictactoe_348;

/**
 * Created by Xin on 9/5/2016.
 */
public class TicTacToe {
    int rows[];
    int columns[];
    int diags[];
    int n;
    final int NOWAY;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        columns = new int[n];
        diags = new int[2];
        this.n =n;
        NOWAY = n+1;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int checkRow = check(rows, row, player, n);
        int checkCol = check(columns, col, player, n);
        int diag1 = row==col ? check(diags, 0, player, n) : 0;
        int diag2 = row == (n-1-col)?check(diags, 1, player, n ):0;

        if (checkRow == 1 || checkCol ==1 || diag1 == 1 || diag2 == 1) {
            return 1;
        } else if (checkRow == 2 || checkCol ==2 || diag1 == 2 || diag2 == 2) {
            return 2;
        } else {
            return 0;
        }
    }

    public int check(int[] a, int pos, int player, int n) {
        if (a[pos] != NOWAY) {
            if (a[pos] == 0) {
                if (player == 1) {
                    a[pos] = 1;
                    return 0;
                } else {
                    a[pos] = -1;
                    return 0;
                }
            } else if (a[pos] >0) {
                if (player == 1) {
                    a[pos]++;
                    if (a[pos] == n) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    a[pos] = NOWAY;
                    return 0;
                }
            } else {
                if (player == 2) {
                    a[pos]--;
                    if (a[pos] == -1*n) {
                        return 2;
                    } else {
                        return 0;
                    }
                } else {
                    a[pos] =NOWAY;
                    return 0;
                }
            }
        } else {
            return 0;
        }
    }
}