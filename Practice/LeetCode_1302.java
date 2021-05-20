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
    
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }
    
    public int levelSum(TreeNode root, int level){
        if(root == null){
            return 0;
        }
        
        if(level == 1){
            return root.val;
        }
        
        return levelSum(root.left, level - 1) + levelSum(root.right, level - 1);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        return levelSum(root,depth(root));
    }
}
