/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode mirrorTree(TreeNode root){
        if(root == null){
            return null;
        }
        
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
    
    public boolean similarTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        
        if(root1 == null || root2 == null){
            return false;
        }
        
        if(root1.val != root2.val){
            return false;
        }
        
        boolean leftAns = similarTree(root1.left,root2.left);
        boolean rightAns = similarTree(root1.right,root2.right);
        
        return leftAns && rightAns;
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        
        if(root.left == null && root.right == null){
            return true;
        }
        
        if((root.left != null && root.right == null) || (root.left == null && root.right != null)){
            return false;
        }
        
        TreeNode mirror = mirrorTree(root.right);
        
        if(similarTree(root.left,mirror)){
            return true;
        }
        
        return false;
    }
}
