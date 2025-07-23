package code.in.tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {
    public List<List<Integer>> allPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, result);
        return result;
    }

    public void dfs(TreeNode root, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        dfs(root.left, path, result);
        dfs(root.right, path, result);
        path.remove(path.size() - 1);
    }
}
