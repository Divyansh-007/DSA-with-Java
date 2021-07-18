/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;
    public boolean helper(TreeNode curr, TreeNode p, TreeNode q){
        if(curr == null){
            return false;
        }
        
        boolean leftAns = helper(curr.left,p,q);
        int left;
        if(leftAns == true){
            left = 1;
        }else{
            left = 0;
        }
        
        boolean rightAns = helper(curr.right,p,q);
        int right;
        if(rightAns == true){
            right = 1;
        }else{
            right = 0;
        }
        
        int mid;
        if(curr == p || curr == q){
            mid = 1;
        }else{
            mid = 0;
        }
        
        if(mid + left + right >= 2){
            ans = curr;
        }
        
        return (mid + left + right > 0);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return ans;
    }
}
