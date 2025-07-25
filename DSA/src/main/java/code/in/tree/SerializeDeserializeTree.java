package code.in.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {

    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                sb.append(curr.val).append(",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                sb.append("null, ");
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if(!values[i].equals("null")){
                TreeNode leftChild = new TreeNode(Integer.parseInt(values[i]));
                current.left = leftChild;
                queue.offer(leftChild);
            }
            i++;
            if(i < values.length && !values[i].equals("null")){
                TreeNode rightChild = new TreeNode(Integer.parseInt(values[i]));
                current.right = rightChild;
                queue.offer(rightChild);
            }
            i++;
        }
        return root;
    }
}
