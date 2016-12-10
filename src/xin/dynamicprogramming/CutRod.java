package xin.dynamicprogramming;

import xin.general.GeneralUtil;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Xin on 7/25/2016.
 */
public class CutRod {
    public static void main(String[] args) {
        ArrayList<Integer> price = new ArrayList<>();
        price.add(0);
        price.add(1);
        price.add(5);
        price.add(8);
        price.add(9);
        price.add(10);
        price.add(17);
        price.add(17);
        price.add(20);
        price.add(24);
        price.add(30);

        ArrayList<Integer> firstCut = GeneralUtil.initializeArrayList(price.size() + 1);
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.next());
        int highestPrice = cutRot(length, price, firstCut);
        System.out.println("highest value: " + highestPrice);
        printCuts(firstCut, length);
    }

    public static void printCuts(ArrayList<Integer> firstCut, int length) {
        while (length > 0) {
            System.out.print(firstCut.get(length) + " ");
            length = length - firstCut.get(length);
        }
    }

    public static int cutRot(int length, ArrayList<Integer> price, ArrayList<Integer> firstCut) {
        ArrayList<Integer> highestCut = GeneralUtil.initializeArrayList(length+1);

        highestCut.set(0, 0);
        firstCut.set(0, 0);

        for (int i = 1; i <= length; i++) {
            int curr_max = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                if (curr_max < price.get(j) + highestCut.get(i - j)) {
                    curr_max = price.get(j) + highestCut.get(i - j);
                    firstCut.set(i, j);
                }
            }
            highestCut.set(i, curr_max);
        }

        return highestCut.get(length);
    }
}
