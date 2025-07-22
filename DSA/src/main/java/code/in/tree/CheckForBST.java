package code.in.tree;

import java.util.ArrayList;
import java.util.List;

public class CheckForBST {
    //Brute Force
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public boolean isValidBST(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for(int i=1; i<list.size(); i++){
            if(list.get(i) <= list.get(i-1)){
                return false;
            }
        }
        return true;
    }
    //Optimal
    public boolean isValidBSTOptimized(TreeNode root){
       return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean isBST(TreeNode root, int min, int max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        boolean leftIsValid = isBST(root.left, min, root.val);
        boolean rightIsValid = isBST(root.right, root.val, max);
        return leftIsValid && rightIsValid;
    }
}
