package xin.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Xin on 6/19/2016.
 */
public class GeneralUtil {
    static Random rand = new Random();
    static Random randSign = new Random();
    static final int MAX = 100;

    public static ArrayList<Integer> generateRandomList(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int sign = randSign.nextInt(2) % 2 == 0 ? 1 : -1;
            list.add(sign * rand.nextInt(MAX));
        }
        return list;
    }

    public static ArrayList<Integer> generateRandomPositiveList(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(MAX));
        }
        return list;
    }

    public static Integer[] generateRandomArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(MAX);
        }
        return array;
    }

    public static <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public static void printList(List<?> list) {
        list.forEach(v -> System.out.print(v + " "));
        System.out.println("");
    }

    public static int generateRandomInt(int max) {
        return rand.nextInt(max);
    }

    public static <T> ArrayList<T> initializeArrayList(int size) {
        ArrayList<T> list = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            list.add(null);
        }
        return list;
    }
}
