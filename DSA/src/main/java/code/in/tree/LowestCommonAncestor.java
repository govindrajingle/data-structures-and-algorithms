package code.in.tree;

public class LowestCommonAncestor {
    public TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.val == n1 || root.val == n2) {
            return root;
        }
        TreeNode leftLCA = findLCA(root.left, n1, n2);
        TreeNode rightLCA = findLCA(root.right, n1, n2);
        // Condition to check the LCA
        if (leftLCA != null && rightLCA != null)
            return root;
        return leftLCA != null ? leftLCA : rightLCA;
    }
}
