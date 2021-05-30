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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        List<Integer> left = inorderTraversal(root.left);
        
        if(left == null){
            List<Integer> ans = new ArrayList<>();
            ans.add(root.val);
            
            List<Integer> right = inorderTraversal(root.right);
            
            if(right == null){
                return ans;
            }else{
                for(int i = 0; i < right.size(); i++){
                    ans.add(right.get(i));
                }
                
                return ans;
            }
        }else{
            left.add(root.val);
            
            List<Integer> right = inorderTraversal(root.right);
            
            if(right == null){
                return left;
            }else{
                for(int i = 0; i < right.size(); i++){
                    left.add(right.get(i));
                }
                
                return left;
            }
        }
    }
}
