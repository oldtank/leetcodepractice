package xin.interview.morristraversal;

/**
 * Created by Xin on 11/19/2016.
 */
public class Inorder {
    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.println(curr.value);
                curr = curr.right;
            }

            Node pre = curr.left;
            while (pre.right != null && pre.right != curr) {
                pre = pre.right;
            }

            if (pre.right == null) {
                pre.right = curr;
                curr = curr.left;
            } else {
                pre.right = null;
                System.out.println(curr.value);
                curr = curr.right;
            }
        }
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.println(curr.value);
                curr = curr.right;
            }

            Node pre = curr.left;
            while (pre.right != null && pre.right != curr) {
                pre = pre.right;
            }

            if (pre.right == null) {
                pre.right = curr;
                System.out.println(curr.value);
                curr = curr.left;
            } else {
                pre.right = null;
                curr = curr.right;
            }
        }
    }
}
