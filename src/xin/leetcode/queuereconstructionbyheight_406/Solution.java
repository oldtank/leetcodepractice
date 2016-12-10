package xin.leetcode.queuereconstructionbyheight_406;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Xin on 9/29/2016.
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return p1[0]!=p2[0]?Integer.compare(p2[0],p1[0]): Integer.compare(p1[1],p2[1]);
            }
        });
        for (int[] p : people) {
            System.out.print("[" + p[0] +","+p[1]+"] ");
        }
        System.out.println();
        List<int[]> list = new LinkedList();
        for (int[] ppl: people) list.add(ppl[1], ppl);
        return list.toArray(new int[people.length][] );
    }
}