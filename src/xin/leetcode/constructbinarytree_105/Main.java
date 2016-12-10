package xin.leetcode.constructbinarytree_105;

/**
 * Created by Xin on 8/28/2016.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int pre_order[] = {1,2};
        int in_order[] = {2, 1};
        solution.buildTree(pre_order, in_order);
    }
}
