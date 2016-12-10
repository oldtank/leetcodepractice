package xin.leetcode.evaluatedivision_399;

/**
 * Created by Xin on 9/22/2016.
 */
public class Main {
    public static void main(String[] args) {
        String[][] equations = {{"a","b"}, {"b", "c"}};
        double[] values = {2.0,3.0};
//        String[][] queries = {{"a","c"}, {"b","c"},{"a","e"},{"a","a"},{"x","y"}};
        String[][] queries = {{"b","c"}};

        new Solution().calcEquation(equations, values, queries);
    }
}
