package code.in.tree;

import java.util.ArrayList;
import java.util.List;

public class KthLargestBST {
    List<Integer> inorderList = new ArrayList<>();
    public int kthLargest(TreeNode root, int k){
        inorder(root);
        return inorderList.get(inorderList.size() - k);
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }
}
