package xin.leetcode.zigzagiterator_281;

import java.util.List;

/**
 * Created by Xin on 8/31/2016.
 */
public class ZigZagIterator {

    List<Integer> lists[];
    int currList;
    int[] i;
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        lists = new List[2];
        lists[0] = v1;
        lists[1] = v2;
        currList = v1.isEmpty() ? 1 : 0;
        i = new int[2];
        i[0] = 0;
        i[1] = 0;
    }

    public int next() {
        int val;
        if (hasNext()) {
            val= lists[currList].get(i[currList]);
        } else {
            val = -1;
        }
        i[currList]++;

        int nextList = (currList + 1)%2;
        if (i[nextList] < lists[nextList].size()) {
            currList = nextList;
        }
        return val;
    }

    public boolean hasNext() {
        return i[currList] < lists[currList].size();
    }
}