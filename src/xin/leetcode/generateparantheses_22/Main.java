package xin.leetcode.generateparantheses_22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 8/26/2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(generate(3));
    }

    public static List<String> generate(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<2*n;i++) {
            sb.append(" ");
        }
        generateHelper(n, 0, sb, 0, list);
        return list;
    }

    public static void generateHelper(int leftRemaining, int rightValid, StringBuilder sb, int pos, List<String> list) {
        if (leftRemaining ==0 && rightValid ==0) {
            list.add(sb.toString());
            return;
        }
        if (leftRemaining > 0) {
            sb.setCharAt(pos, '(');
            generateHelper(leftRemaining-1, rightValid+1, sb, pos+1, list);
        }
        if (rightValid > 0) {
            sb.setCharAt(pos, ')');
            generateHelper(leftRemaining, rightValid-1, sb, pos+1, list);
        }
    }
}
