package xin.leetcode.queuereconstructionbyheight_406;

/**
 * Created by Xin on 9/29/2016.
 */
public class Main {
    public static void main(String[] args) {
        int queue[][] = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int arranged[][] = new Solution().reconstructQueue(queue);

        for (int[] p : arranged) {
            System.out.print("[" + p[0]+","+p[1]+"]");
        }
    }
}
