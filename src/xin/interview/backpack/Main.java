package xin.interview.backpack;

/**
 * Created by Xin on 10/8/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        System.out.println(new Backpack().findMaxValue(capacity, values, weights));
    }
}
