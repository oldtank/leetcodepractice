package xin.ctci.c9q6;

/**
 * Created by Xin on 8/22/2016.
 */
public class Main {
    public static void main(String[] args) {
        printBrackets("", 3, 3, 0);
    }

    public static void printBrackets(String s, int l, int r, int n) {
        if (l==0 && r==0) {
            System.out.println(s);
            return;
        }
        if (l > 0) {
            s = s+"(";
            printBrackets(s, l-1, r, n+1);
            s = s.substring(0, s.length()-1);
        }
        if (n > 0 && r >0) {
            s += ")";
            printBrackets(s, l, r-1, n-1);
        }
    }
}
