package xin.datastructure.avltree;

/**
 * Created by Xin on 7/26/2016.
 */
public class AvlTree<T extends Comparable> {
    private Node<T> root;

    public int height(Node n) {
        if (n == null) {
            return 0;
        } else {
            return n.getHeight();
        }
    }

    public Node rightRotate(Node x) {
        if (x.getLeft() == null) {
            return x;
        }

        Node y = x.getLeft();
        x.setLeft(y.getRight());
        y.setRight(x);

        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        return y;
    }

    public Node leftRotate(Node x) {
        if (x.getRight() == null) {
            return x;
        }

        Node y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);

        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        return y;
    }

    public int getBalance(Node n) {
        if (n == null) {
            return 0;
        } else {
            return height(n.getLeft()) - height(n.getRight());
        }
    }

    public void insert(T value) {
        this.root = insert(this.root, value);
    }

    public Node insert(Node root, T value) {
        if (root == null) {
            return new Node(value);
        }

        if (value.compareTo(root.getValue()) < 0) {
            root.left = insert(root.getLeft(), value);
        }

        if (value.compareTo(root.getValue()) >= 0) {
            root.right = insert(root.getRight(), value);
        }

        root.setHeight(max(height(root.getRight()), height(root.getLeft())) + 1);
        int balance = getBalance(root);
        if (balance > 1 && value.compareTo(root.getLeft().getValue()) < 0) {
            return rightRotate(root);
        }

        if (balance < -1 && value.compareTo(root.getRight().getValue())>0) {
            return rightRotate(root);
        }

        if (balance > 1 && value.compareTo(root.getLeft().getValue()) > 0) {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }

        if (balance < -1 && value.compareTo(root.getRight().getValue()) < 0) {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }

        return root;
    }

    public void printTree() {
        if (this.root == null) {
            return;
        }
        printTree(this.root, "", true);
    }

    public void printTree(Node root, String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "\\" : "|" ) + "-" + root.getValue());
        if (root.getLeft() == null && root.getRight() != null) {
            printTree(root.getRight(), prefix + (isTail ? "  " : "| "), true);
        } else if (root.getLeft() != null && root.getRight() == null) {
            printTree(root.getLeft(), prefix + (isTail ? "  " : "| "), true);
        } else if (root.getLeft() != null && root.getRight() != null) {
            printTree(root.getLeft(), prefix + (isTail ? "  " : "| "), false);
            printTree(root.getRight(), prefix + (isTail ? "  " : "| "), true);
        }
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}
