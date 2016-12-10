package xin.ctci.c11q1;

/**
 * Created by Xin on 8/23/2016.
 */
public class MergeAB {
    public static void merge(int[] arrayA, int[] arrayB) {
        int result_index = arrayA.length + arrayB.length -1;
        int indexA = arrayA.length-1, indexB = arrayB.length-1;
        while(indexB >=0 && indexA >=0) {
            if (arrayA[indexA] <= arrayB[indexB]) {
                arrayA[result_index] = arrayB[indexB];
                indexB--;
            } else {
                arrayA[result_index] = arrayB[indexB];
                indexA--;
            }
        }
        if (indexA <0) {
            for (int index = indexB; index>=0; index--) {
                arrayA[result_index] = arrayB[index];
                result_index--;
            }
        }
    }
}
