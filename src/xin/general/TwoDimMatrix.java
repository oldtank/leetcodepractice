package xin.general;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by Xin on 7/28/2016.
 */
@Data
public class TwoDimMatrix<T> {
    private int rowSize;
    private int colSize;
    private ArrayList<ArrayList<T>> matrix;

    public TwoDimMatrix(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;

        matrix = new ArrayList<ArrayList<T>>();
        for (int r = 0; r < this.rowSize; r++) {
            ArrayList<T> row = new ArrayList<T>();
            for (int c = 0; c < this.colSize; c++) {
                row.add(null);
            }
            matrix.add(row);
        }
    }

    public T get(int r, int c) {
        return matrix.get(r).get(c);
    }

    public void set(int r, int c, T value) {
        matrix.get(r).set(c, value);
    }
}
