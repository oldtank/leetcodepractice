package xin.leetcode.numberofislandsii_305;

/**
 * Created by Xin on 9/16/2016.
 */
public class UnionFind {
    int N;
    int sizes[];
    int id[];
    int count;

    public UnionFind(int x, int y) {
        N=y;
        sizes = new int[x*y];
        id = new int[x*y];
        for (int i=0; i<x*y; i++) {
            id[i] = -1;
            sizes[i] = 0;
        }
        count = 0;
    }

    public int index(int x, int y) {
        return x*N+y;
    }

    public void add(int i) {
        if (id[i] == -1) {
            id[i] = i;
            sizes[i] = 1;
            count++;
        }
    }

    public boolean alreadyAdded(int x, int y) {
        return id[index(x, y)] != -1;
    }

    public void add(int x, int y) {
        int i = index(x, y);
        add(i);
    }

    public int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return id[i];
    }

    public boolean sameSet(int i, int j) {
        return root(i) == root(j);
    }

    public void union(int i, int j) {
        int rooti = root(i);
        int rootj = root(j);

        if (rooti != rootj) {
            if (sizes[rooti] < sizes[rootj]) {
                id[rooti] = rootj;
                sizes[rootj] += sizes[rooti];
            } else {
                id[rootj] = rooti;
                sizes[rooti] += sizes[rootj];
            }
            count--;
        }
    }
}
