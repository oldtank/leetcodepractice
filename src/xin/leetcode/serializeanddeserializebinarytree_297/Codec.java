package xin.leetcode.serializeanddeserializebinarytree_297;

/**
 * Created by Xin on 9/7/2016.
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("|,");
            return;
        }
        sb.append(root.val+",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

//     Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String tokens[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        deserializeHelper(root, 1, tokens);
        return root;
    }

    public int deserializeHelper(TreeNode parent, int i, String[] tokens) {
        if (parent == null) {
            return i;
        }
        if (tokens[i].equals("|")) {
            parent.left = null;
        } else {
            parent.left = new TreeNode(Integer.parseInt(tokens[i]));
        }
        int next = deserializeHelper(parent.left, i+1, tokens);

        if (tokens[next].equals("|")) {
            parent.right = null;
        } else {
            parent.right = new TreeNode(Integer.parseInt(tokens[next]));
        }
        return deserializeHelper(parent.right, next+1, tokens);
    }
}
