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
    int count = 0;
    
    void helper(TreeNode root, int max){
        if(max <= root.val){
            count++;
        }
        
        if(root.right != null){
            helper(root.right, Math.max(root.val,max));
        }
        
        if(root.left != null){
            helper(root.left, Math.max(root.val,max));
        }
    }
    
    public int goodNodes(TreeNode root) {
        helper(root,Integer.MIN_VALUE);
        return count;
    }
}
