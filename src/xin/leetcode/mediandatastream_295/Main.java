package xin.leetcode.mediandatastream_295;

/**
 * Created by Xin on 9/8/2016.
 */
public class Main {
    public static void main(String[] args) {
        MedianFinder mf=new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());

    }
}
