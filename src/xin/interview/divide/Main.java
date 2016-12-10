package xin.interview.divide;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Xin on 8/21/2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(divide(1,2));
    }

    public static String divide(int a, int b) {
        String result = "";
        double double_a = a;
        double temp = double_a/b;
        if (temp%1==0) {
            return "" + a/b;
        }
        result += a/b + ".";
        String decimal = "";

        ArrayList<Integer> seenRemainder = new ArrayList<>();
        HashSet<Integer> seenRemainderSet = new HashSet<>();
        int currentRemainder = a%b;
        while (!seenRemainderSet.contains(currentRemainder)) {
            seenRemainder.add(currentRemainder);
            seenRemainderSet.add(currentRemainder);
            currentRemainder = currentRemainder*10%b;
        }
        for (Integer remainder : seenRemainder) {
            if (remainder == currentRemainder) {
                result += "{";
            }
            result += remainder*10/b;
        }
        result += "}";
        return result;
    }
}
