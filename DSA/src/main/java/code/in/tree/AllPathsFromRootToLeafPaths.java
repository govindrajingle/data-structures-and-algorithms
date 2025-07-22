package code.in.tree;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromRootToLeafPaths {
    public void printPaths(TreeNode root, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            System.out.println(root.val);
        } else {
            printPaths(root.left, path);
            printPaths(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public void printAllPaths(TreeNode root) {
        printPaths(root, new ArrayList<>());
    }
}
