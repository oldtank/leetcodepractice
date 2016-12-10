package xin.misc.unionfind;

/**
 * Created by Xin on 10/1/2016.
 */
public class UnionFind {
    int[] uf;
    int[] size;
    // number of disjoint sets
    int count;

    UnionFind(int N) {
        uf = new int[N];
        size = new int[N];
        for (int i=0; i<N; i++) {
            uf[i] = -1;
            size[i] = 0;
        }
    }

    public void add(int i) {
        if (uf[i] == -1) {
            uf[i] = i;
            size[i] = 1;
            count++;
        }
    }

    public int root(int i) {
        if (uf[i] == -1) {
            return -1;
        }
        while (uf[i] != i) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return uf[i];
    }

    public void union(int i, int j) {
        int rooti = root(i);
        int rootj = root(j);
        if (rooti != rootj) {
            if (size[rooti] < size[rootj]) {
                uf[rooti] = rootj;
                size[rootj] += size[rooti];
            } else {
                uf[rootj] = rooti;
                size[rooti] += size[rootj];
            }
        }
    }

    public boolean sameSet(int i, int j) {
        return root(i) == root(j);
    }
}
