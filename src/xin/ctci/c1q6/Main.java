package xin.ctci.c1q6;

/**
 * Created by Xin on 8/20/2016.
 */
public class Main {

    public static void main(String[] args) {
        int[][] matrix = { {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        int N = matrix[0].length;
        printMatrix(matrix, N);
        rotate(matrix, N);
        printMatrix(matrix, N);

    }

    public static void printMatrix(int[][] m, int N) {
        for (int i = 0; i<N; i++) {
            for(int j=0; j<N; j++){
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void rotate(int[][] matrix, int N) {
        int layer = 0;
        while(layer <= N/2-1) {
            for (int i=layer; i<=N-2-layer; i++) {
                int temp = matrix[layer][i];
                matrix[layer][i] = matrix[N-1-i][layer];
                matrix[N-1-i][layer] = matrix[N-1-layer][N-1-i];
                matrix[N-1-layer][N-1-i] = matrix[i][N-1-layer];
                matrix[i][N-1-layer] = temp;
            }
            layer ++;
        }
    }
}
