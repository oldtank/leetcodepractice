package xin.leetcode.longestabsolutefilepath_368;

import java.util.*;

/**
 * Created by Xin on 8/31/2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

    public static int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int max = 0;
        String last_del = "";
        Stack<String> path = new Stack<>();
        String tokens[] = input.split("\n");
        for (int x=0; x<tokens.length; x++) {
            String currLoc = tokens[x];
            int i=0;
            for (; i<currLoc.length(); i++) {
                if (currLoc.charAt(i) != '\t' && currLoc.charAt(i) != 'n') {
                    break;
                }
            }
            String delimiter = currLoc.substring(0, i);
            String locName = currLoc.substring(i);
            if (delimiter.length() > last_del.length()) {
                path.push(locName);
            } else {
                for (int j=last_del.length() - delimiter.length(); j>=0; j--) {
                    if (path.size() > 0) {
                        path.pop();
                    }
                }
                path.push(locName);
            }
            last_del = delimiter;
            if (locName.indexOf(".") > 0) {
                max = Math.max(max, pathLength(path));
            }
        }
        return max;
    }


    public static int pathLength(Stack<String> stack) {
        int length = 0;
        for (String dir : stack) {
            length += dir.length();
        }
        length += stack.size()-1;
        return length;
    }
}
