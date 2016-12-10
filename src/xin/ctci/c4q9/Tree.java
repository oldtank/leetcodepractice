package xin.ctci.c4q9;

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

    public void inOrderPrint(Node from) {
        if (from == null) {
            return;
        }
        inOrderPrint(from.getLeft());
        System.out.print(from.getValue() + " ");
        inOrderPrint(from.getRight());
    }

    public void deserialize(ArrayList<Integer> list) {
        root = new Node(list.get(0));
        deserializeHelper(root, list, 1);
    }

    public int deserializeHelper(Node curr, ArrayList<Integer> list, int pos) {
        if (curr == null) {
            return pos;
        }
        int leftValue = list.get(pos);
        if (leftValue != -1) {
            curr.setLeft(new Node(leftValue));
        } else {
            curr.setLeft(null);
        }

        int nextPos = deserializeHelper(curr.getLeft(), list, pos+1);

        int rightValue = list.get(nextPos);
        if (rightValue != -1) {
            curr.setRight(new Node(rightValue));
        } else {
            curr.setRight(null);
        }
        return deserializeHelper(curr.getRight(), list, nextPos + 1);

    }

    public ArrayList<Integer> serialize() {
        ArrayList<Integer> result = new ArrayList<>();
        serializeHelper(this.root, result);
        return result;
    }

    public void serializeHelper(Node from, ArrayList<Integer> result) {
        if (from==null) {
            result.add(-1);
        } else {
            result.add(from.getValue());
            serializeHelper(from.getLeft(), result);
            serializeHelper(from.getRight(), result);
        }
    }

    public void printPaths() {
        printPathsHelper(this.root, new ArrayList<>());
    }

    public void printPathsHelper(Node from, ArrayList<Integer> path) {
        if (from.getLeft() == null && from.getRight() == null) {
            path.add(from.getValue());
            printPath(path);
            path.remove(path.size()-1);
        }
        path.add(from.getValue());
        if (from.getLeft() != null) {
            printPathsHelper(from.getLeft(), path);
        }
        if (from.getRight() != null) {
            printPathsHelper(from.getRight(), path);
        }
        path.remove(path.size()-1);
    }

    private void printPath(ArrayList<Integer> list) {
        list.forEach(e -> System.out.print(e + " "));
        System.out.println();
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

    public void findPathofSum(int sum) {
        findPathsOfSumHelper(root, sum, new ArrayList<>());
    }

    private void findPathsOfSumHelper(Node from, int sum, ArrayList<Integer> path) {
        if (from == null) {
            return;
        }

        path.add(from.getValue());
        int tmp=0;
        for (int i=path.size()-1; i>=0; i--) {
            tmp+=path.get(i);
            if (tmp == sum) {
                printOnePath(path, i, path.size()-1);
            }
        }
        findPathsOfSumHelper(from.getLeft(), sum, path);
        findPathsOfSumHelper(from.getRight(), sum, path);

        path.remove(path.size()-1);
    }

    private void printOnePath(ArrayList<Integer> path, int from, int to) {
        for(int i=from; i<=to; i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
}
