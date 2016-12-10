package xin.maxsubarray;

/**
 * Created by Xin on 6/19/2016.
 */

public class MaxSubArray {
    private int max;
    private int start;
    private int end;

    public MaxSubArray() {
        max = Integer.MIN_VALUE;
        start = -1;
        end = -1;
    }

    public MaxSubArray(int max, int start, int end) {
        this.max = max;
        this.start = start;
        this.end = end;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
