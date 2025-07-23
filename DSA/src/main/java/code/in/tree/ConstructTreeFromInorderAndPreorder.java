package code.in.tree;

import java.util.HashMap;

public class ConstructTreeFromInorderAndPreorder {
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return construct(preorder, 0, inorder.length - 1);
    }

    public TreeNode construct(int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int rootVal = preorder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = inorderMap.get(rootVal);
        root.left = construct(preorder, inorderStart, inorderIndex - 1);
        root.right = construct(preorder, inorderIndex + 1, inorderEnd);
        return root;
    }
}
