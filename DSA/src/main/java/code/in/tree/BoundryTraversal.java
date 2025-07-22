package code.in.tree;

import java.util.ArrayList;
import java.util.List;

public class BoundryTraversal {
    public boolean isLeaf(TreeNode root) {
        return root != null &&
                root.left == null &&
                root.right == null;

    }

    public void addLeftBoundry(TreeNode root, List<Integer> result) {
        while (root != null) {
            if (!isLeaf(root)) {
                result.add(root.val);
            }
            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    public void addLeaves(TreeNode root, List<Integer> result) {
        if (root == null) return;
        if (isLeaf(root)) {
            result.add(root.val);
            return;
        }
        addLeaves(root.left, result);
        addLeaves(root.right, result);
    }

    public void addRightBoundry(TreeNode root, List<Integer> result) {
        List<Integer> temp = new ArrayList<>();
        while (root != null) {
            if (!isLeaf(root)) {
                temp.add(root.val);
            }
            if (root.right != null) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }
}
