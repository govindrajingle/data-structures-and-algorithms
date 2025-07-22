package code.in.tree;

//Diameter of the tree can be considered as the longest path between any two nodes that may be passes throught the root node

public class DiameterOfBinaryTree {
    //Brute
    public int diameter(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHight = height(root.right);
        int diameterRoot = leftHeight + rightHight;
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return Math.max(diameterRoot, Math.max(leftDiameter, rightDiameter));
    }

    public int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int diameter2(TreeNode root) {
        int[] result = new int[1];
        height2(root, result);
        return result[0];
    }

    public int height2(TreeNode node, int[] result) {
        if (node == null) return 0;
        int leftHeight = height2(node.left, result);
        int rightHeight = height2(node.right, result);
        result[0] = Math.max(result[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
