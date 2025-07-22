package code.in.tree;

public class ConvertBinaryTreeToDoublyLinkedList {

    TreeNode prev = null;
    TreeNode head = null;

    public void convertToDLL(TreeNode root) {
        if (root == null)
            return;
        convertToDLL(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertToDLL(root.right);
    }

}
