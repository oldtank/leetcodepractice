package xin.leetcode.designtictactoe_348;

/**
 * Created by Xin on 9/5/2016.
 */
public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(2);
        System.out.println(ticTacToe.move(0,1,1));
        System.out.println(ticTacToe.move(1,1,2));
        System.out.println(ticTacToe.move(1,0,1));

    }
}
