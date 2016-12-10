package xin.leetcode.countofsmallernumbersafterself_315;

/**
 * Created by Xin on 9/16/2016.
 */
public class BST {
    public class TreeNode {
        int val, count;
        TreeNode left, right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
            count = 0;
        }
    }

    TreeNode root;
    public BST() {
        root = null;
    }

    public int insert(int v) {
        if (root == null) {
            root = new TreeNode(v);
            return 0;
        }

        TreeNode curr = root, prev = null;
        int c=0;
        while (curr != null) {
            prev = curr;
            if (v <= curr.val) {
                curr.count++;
                curr = curr.left;
            } else {
                c += curr.count+1;
                curr = curr.right;
            }
        }

        System.out.println("inserting val " + v + " with count " + c);
        TreeNode node = new TreeNode(v);
        if (v <= prev.val) {
            prev.left = node;
        } else {
            prev.right = node;
        }
        return c;
    }
}
