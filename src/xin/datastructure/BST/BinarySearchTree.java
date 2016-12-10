package xin.datastructure.BST;

/**
 * Created by Xin on 7/21/2016.
 */
public class BinarySearchTree<T extends Comparable> {
    Element<T> root;
    int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public Element getRoot() {
        return this.root;
    }

    public void inOrder(Element start) {
        if (start != null) {
            inOrder(start.getLeft());
            System.out.print(start.getValue() + " ");
            inOrder(start.getRight());
        }
    }

    public Element search_recursive(Element start, T key) {
        if (start == null || start.getValue().compareTo(key)==0) {
            return start;
        }
        if (start.getValue().compareTo(key) < 0) {
            return search_recursive(start.getRight(), key);
        } else {
            return search_recursive(start.getLeft(), key);
        }
    }

    public Element search_iterative(Element start, T key) {
        while (start != null && start.getValue().compareTo(key) != 0) {
            if (key.compareTo(start.getValue()) > 0) {
                start = start.getRight();
            } else {
                start = start.getLeft();
            }
        }
        return start;
    }

    public Element min(Element start) {
        while(start != null) {
            start = start.getLeft();
        }
        return start;
    }

    public Element max(Element start) {
        while (start != null) {
            start = start.getRight();
        }
        return start;
    }

    /**
     * smallest key greater than given input
     * @param x
     * @return
     */
    public Element successor(Element x) {
        if (x.getRight() != null) {
            return min(x.getRight());
        }
        Element parent = x.getParent();
        while(parent != null && parent.getRight() == x) {
            x = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    /**
     * largest key smaller than given input
     *
     * @param x
     * @return
     */
    public Element predecessor(Element x) {
        if (x.getLeft() != null) {
            return max(x.getLeft());
        }

        Element parent = x.getParent();
        while (parent != null && parent.getLeft() == x) {
            x = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    public void insert_iterative(Element e) {
        size++;
        if (root == null) {
            root = e;
            return;
        }
        Element x = this.root;
        Element parent = null;
        while (x != null) {
            parent = x;
            parent.setHeight(parent.getHeight() + 1);
            if (x.getValue().compareTo(e.getValue()) < 0) {
                x = x.getRight();
            } else {
                x = x.getLeft();
            }
        }
        e.setParent(parent);
        if (parent.getValue().compareTo(e.getValue()) < 0) {
            parent.setRight(e);
        } else {
            parent.setLeft(e);
        }
    }
    /**
     * replace subtree rooted at u with that rooted at v
     * @param u
     * @param v
     */
    public void transplant(Element u, Element v) {
        if (u.getParent() == null) {
            root = v;
        } else {
            if (u == u.getParent().getLeft()) {
                u.getParent().setLeft(v);
            } else {
                u.getParent().setRight(v);
            }
        }
        if (v != null) {
            v.setParent(u.getParent());
        }
    }

    public void delete(Element e) {
        if (e.getLeft() == null) {
            transplant(e, e.getRight());
        } else if (e.getRight() == null) {
            transplant(e, e.getLeft());
        } else {
            Element replace = min(e.getRight());
            if (replace.getParent() != e) {
                transplant(replace, replace.getRight());
                replace.setRight(e.getRight());
                replace.getRight().setParent(replace);
            }
            transplant(e, replace);
            replace.setLeft(e.getLeft());
            replace.getLeft().setParent(replace);
        }
    }

    public void printPrettyTree(Element start) {
        if (start == null) {
            return;
        } else {
            printPrettyTree(start, "", true);
        }
    }

    public void printPrettyTree(Element curr, String prefix, boolean isLastChild) {
        if (curr == null) {
            return;
        }
        System.out.println(prefix + (isLastChild ? "└" : "|") + "-" + curr.getValue() + "(" + curr.getHeight() + ")");
        if (curr.getLeft() == null && curr.getRight() != null) {
            printPrettyTree(curr.getRight(), prefix + (isLastChild ? "  " : "| "), true);
        } else if (curr.getRight() == null && curr.getLeft() != null) {
            printPrettyTree(curr.getLeft(), prefix + (isLastChild ? "  " : "| "), true);
        } else {
            printPrettyTree(curr.getLeft(), prefix + (isLastChild ? "  " : "| "), false);
            printPrettyTree(curr.getRight(), prefix + (isLastChild ? "  " : "| "), true);
        }
    }

}
