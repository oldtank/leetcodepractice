package xin.datastructure.segmenttree;

/**
 * Created by Xin on 9/27/2016.
 */
public class SegmentTree {
    int source[];
    int tree[];
    int N;

    public SegmentTree(int[] source) {
        N = source.length;
        tree = new int[100];
        this.source = new int[source.length];
        for (int i=0; i<N; i++) {
            this.source[i] = source[i];
        }
        constructHelper(0, 0, N-1, source);
    }

    public int getSum(int segStart, int segEnd) {
        return getSumHelper(0, 0, N-1, segStart, segEnd);
    }

    public void update(int pos, int newValue) {
        int toAdd = newValue - source[pos];
        source[pos] = newValue;
        updateHelper(0, 0, N-1, pos, toAdd);
    }

    private void updateHelper(int currIndex, int coveredLeft, int coveredRight, int pos, int toAdd) {
        if (pos < coveredLeft || pos > coveredRight) {
            return;
        }

        tree[currIndex] += toAdd;
        if (coveredLeft != coveredRight) {
            int mid = (coveredLeft + coveredRight) / 2;
            updateHelper(left(currIndex), coveredLeft, mid, pos, toAdd);
            updateHelper(right(currIndex), mid + 1, coveredRight, pos, toAdd);
        }
    }

    private int getSumHelper(int currIndex, int coveredLeft, int coveredRight, int segStart, int segEnd) {
        if (segStart <= coveredLeft && segEnd >= coveredRight) {
            return tree[currIndex];
        }

        if (segEnd < coveredLeft || segStart > coveredRight) {
            return 0;
        }

        int mid = (coveredLeft + coveredRight) / 2;
        return getSumHelper(left(currIndex), coveredLeft, mid, segStart, segEnd)
                + getSumHelper(right(currIndex), mid+1, coveredRight, segStart, segEnd);
    }

    private int constructHelper(int currIndexInTree, int segStart, int segEnd, int[] source) {
        if (segEnd == segStart) {
//            System.out.println("put original pos " + segStart + " at tree index " + currIndexInTree);
            tree[currIndexInTree] = source[segEnd];
            return source[segEnd];
        }

        int mid = (segStart + segEnd) / 2;
        tree[currIndexInTree] = constructHelper(left(currIndexInTree), segStart, mid, source)
                + constructHelper(right(currIndexInTree), mid+1, segEnd, source);
        return tree[currIndexInTree];
    }

    private int left(int i) {
        return 2*i+1;
    }

    private int right(int i) {
        return 2*i+2;
    }

    private int parent(int i) {
        return (i-1)/2;
    }
}
