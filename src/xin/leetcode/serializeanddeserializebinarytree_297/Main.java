package xin.leetcode.serializeanddeserializebinarytree_297;

/**
 * Created by Xin on 9/7/2016.
 */
public class Main {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left=node5;
        node3.right=node4;

        Codec codec = new Codec();
        String code = codec.serialize(node1);
        System.out.println("code: "+code);
        TreeNode root = codec.deserialize(code);
        System.out.println(codec.serialize(root));
    }
}
