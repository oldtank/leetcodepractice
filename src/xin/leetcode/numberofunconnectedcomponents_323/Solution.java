package xin.leetcode.numberofunconnectedcomponents_323;

/**
 * Created by Xin on 9/5/2016.
 */
public class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n==0) {
            return 0;
        }
        if (edges==null || edges.length==0) {
            return n;
        }
        int inSet[] = new int[n];
        int setCount=n;
        for(int i=0; i<n; i++) {
            inSet[i] = i;
        }

        for (int[] edge:edges) {
            int v1 = edge[0], v2=edge[1];
            int root1 = getRoot(inSet, v1);
            int root2 = getRoot(inSet, v2);
            if (root1 == root2) {
                continue;
            } else {
                inSet[root2] = root1;
                setCount --;
            }
        }
        return setCount;
    }

    public int getRoot(int inSet[], int i) {
        while (inSet[i] != i) {
            i = inSet[i];
        }
        return i;
    }
}