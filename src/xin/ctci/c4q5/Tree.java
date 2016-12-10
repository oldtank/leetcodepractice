package xin.ctci.c4q5;

import lombok.Data;

import java.util.ArrayList;

/**
 * Created by Xin on 8/22/2016.
 */
@Data
public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public void insertBinary(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node curr = root, parent = null;
        while (curr != null) {
            if (value <= curr.getValue()) {
                parent = curr;
                curr = curr.getLeft();
            } else {
                parent = curr;
                curr = curr.getRight();
            }
        }
        if (value <= parent.getValue()) {
            parent.setLeft(new Node(value));
        } else {
            parent.setRight(new Node(value));
        }
    }

    public void inOrderPrint(Node from) {
        if (from == null) {
            return;
        }
        inOrderPrint(from.getLeft());
        System.out.print(from.getValue() + " ");
        inOrderPrint(from.getRight());
    }

    public ArrayList<Integer> inOrderArray(Node from) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrderArray(from, result);
        return result;
    }

    private void inOrderArray(Node from, ArrayList<Integer> result) {
        if (from == null) {
            return;
        }
        inOrderArray(from.getLeft(), result);
        result.add(from.getValue());
        inOrderArray(from.getRight(), result);
    }

    public boolean isBST() {
        return isBST(this.root).isBST;
    }

    private BinaryCheckResult isBST(Node from) {
        if (from == null) {
            return new BinaryCheckResult(true, true, -1, -1);
        }
        BinaryCheckResult leftResult  = isBST(from.getLeft());
        BinaryCheckResult rightResult = isBST(from.getRight());
        if (!leftResult.isBST
                || !rightResult.isBST
                || (!leftResult.isNull && leftResult.largest > from.getValue())
                || (!rightResult.isNull && from.getValue() >= rightResult.smallest)
                ) {
            return new BinaryCheckResult(false, false, -1, -1);
        } else {
            return new BinaryCheckResult(true, false,
                    leftResult.isNull ? from.getValue() : leftResult.smallest,
                    rightResult.isNull ? from.getValue() : rightResult.largest);
        }
    }

    class BinaryCheckResult {
        int smallest;
        int largest;
        boolean isBST;
        boolean isNull;

        BinaryCheckResult(boolean isBST, boolean isNull, int smallest, int largest) {
            this.isBST = isBST;
            this.isNull = isNull;
            this.smallest = smallest;
            this.largest = largest;
        }
    }
}
