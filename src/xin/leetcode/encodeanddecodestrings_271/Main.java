package xin.leetcode.encodeanddecodestrings_271;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Xin on 9/1/2016.
 */
public class Main {
    public static void main(String[] args) {
        String a[] = {"abc", "234", "sdfgasda"};
        List<String> strs = Arrays.asList(a);
        Codec codec = new Codec();
        System.out.println(codec.decode(codec.encode(strs)));
    }
}
