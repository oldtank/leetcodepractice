package xin.datastructure.BST;

/**
 * Created by Xin on 7/21/2016.
 */
public class Element<T extends Comparable> {
    Element left;
    Element right;
    Element parent;
    int height;
    T value;

    public Element(T value) {
        left = null;
        right = null;
        this.value = value;
        this.height = 1;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setValue(T v) {
        this.value = v;
    }


    public T getValue() {
        return this.value;
    }

    public void setLeft(Element e) {
        this.left = e;
    }

    public Element getLeft() {
        return this.left;
    }

    public void setRight(Element e) {
        this.right = e;
    }

    public Element getRight() {
        return this.right;
    }

    public void setParent(Element e) {
        this.parent = e;
    }

    public Element getParent() {
        return this.parent;
    }
}
