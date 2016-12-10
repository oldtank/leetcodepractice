package xin.leetcode.flipgameii_294;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

 Write a function to determine if the starting player can guarantee a win.

 For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

 Follow up:
 Derive your algorithm's runtime complexity.

 https://leetcode.com/problems/flip-game-ii/
 */
public class Main {
    public static void main(String[] args) {
        String s = "-++-++-";
        System.out.println(canWin(s));
    }

    public static boolean canWin(String s) {
        List<String> nextMoves = nextMoves(s);
        if (nextMoves.isEmpty()) {
            return false;
        }
        for (String nextMove : nextMoves) {
            if (!canWin(nextMove)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> nextMoves(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 2) {
            return list;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<=s.length()-2;i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i+1, '-');
                list.add(sb.toString());
                sb.setCharAt(i, '+');
                sb.setCharAt(i+1, '+');
            }
        }
        return list;
    }
}
