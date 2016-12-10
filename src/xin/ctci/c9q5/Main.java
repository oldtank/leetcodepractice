package xin.ctci.c9q5;

/**
 * Created by Xin on 8/22/2016.
 */
public class Main {
    public static void main(String[] args) {
        String s = "abc";
        permutate(s.toCharArray(), 0);
    }

    public static void permutate(char[] s, int pos) {
        if (pos == s.length-1) {
            System.out.println(s);
            return;
        }
        for (int i=pos; i<s.length; i++) {
            swap(s, i, pos);
            permutate(s, pos+1);
            swap(s, i, pos);
        }
    }

    public static void print(char[] s) {
        for (char c : s) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j]=tmp;
    }
}
