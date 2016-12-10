package xin.interview.stringtotree;

/**
 * Created by Xin on 8/21/2016.
 */
public class Deserialize {

    public static void main(String[] args) {
        String tree = "(1(2(345)0))";
        Node head = deserialize(tree);
        head.print();
    }

    public static Node deserialize(String tree) {
        Node head=null;
        Node curr = null;
        for (int i=0; i<tree.length();) {
            String currNum="";
            if (tree.charAt(i) == '(') {
                if (curr == null) {
                    i++;
                    curr = new Node(Integer.parseInt(""+tree.charAt(i)));
                    head = curr;
                    i++;
                } else {
                    i++;
                    Node newChild = new Node(Integer.parseInt(""+tree.charAt(i)));
                    curr.getChildren().add(newChild);
                    newChild.setParent(curr);
                    curr = newChild;
                    i++;
                }
            } else if (tree.charAt(i) >= '0' && tree.charAt(i) <= '9') {
                Node newChild = new Node(Integer.parseInt("" + tree.charAt(i)));
                curr.getParent().getChildren().add(newChild);
                newChild.setParent(curr.getParent());
                i++;
            } else if (tree.charAt(i) == ')') {
                curr = curr.getParent();
                i++;
            }
        }
        return head;
    }
}
