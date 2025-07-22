package code.in.tree;


import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBinaryTree {
    static int maxLevel = -1;

    public static List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    public static void dfs(TreeNode root, int level, List<Integer> result) {
        if (root == null) return;
        if (level > maxLevel) {
            result.add(root.val);
            maxLevel = level;
        }
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<Integer> leftNodes = leftView(root);
        for(int i : leftNodes){
            System.out.print(i+" ");
        }
    }
}
