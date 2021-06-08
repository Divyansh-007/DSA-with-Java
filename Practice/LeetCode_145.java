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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        
        List<Integer> ans = new ArrayList<>();
        
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
        
        ans.add(root.val);
        
        return ans;
    }
}
