package xin.maxsubarray;

import xin.general.GeneralUtil;

import java.util.List;

/**
 * Created by Xin on 6/19/2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = GeneralUtil.generateRandomList(10);
        GeneralUtil.printList(list);
        MaxSubArray maxSubArray = FindMaxSubArray.findMaxSubArray(list);
        System.out.println(String.format("max: %d, start: %d, end: %d", maxSubArray.getMax(), maxSubArray.getStart(), maxSubArray.getEnd()));
    }
}
