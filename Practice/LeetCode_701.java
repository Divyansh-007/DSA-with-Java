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
    
    public void insert(TreeNode root, int val){
        if(root.val < val){
            if(root.right != null){
                insert(root.right,val);
            }else{
                root.right = new TreeNode(val);
                return;
            }
        }else{
            if(root.left != null){
                insert(root.left,val);
            }else{
                root.left = new TreeNode(val);
                return;
            }
        }
    }
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return root;
        }
        
        insert(root,val);
        
        return root;
    }
}
