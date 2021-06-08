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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        
        List<Integer> ans = new ArrayList<>();
        
        ans.add(root.val);
        
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        if(left != null){
            for(int i = 0; i < left.size(); i++){
                ans.add(left.get(i));
            }
        }
        
        if(right != null){
            for(int i = 0; i < right.size(); i++){
                ans.add(right.get(i));
            }
        }
        
        return ans;
    }
}
