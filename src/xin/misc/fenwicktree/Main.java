package xin.misc.fenwicktree;

/**
 * Created by Xin on 10/1/2016.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums =  {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        FenwickTree ft = new FenwickTree(nums);
        System.out.println(ft.getSum(5));
        System.out.println(ft.getSum(2));
        System.out.println(ft.getSum(9));

        ft.increment(8,1);
        System.out.println(ft.getSum(5));
        System.out.println(ft.getSum(9));
    }
}
