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
    
    public List<Integer> inOrder(TreeNode root){
        if(root == null){
            return null;
        }
        
        List<Integer> left = inOrder(root.left);
        
        if(left != null){
            left.add(root.val);
            
            List<Integer> right = inOrder(root.right);
            
            if(right != null){
                for(int i : right){
                    left.add(i);
                }
                
                return left;
            }else{
                return left;
            }
        }else{
            List<Integer> ans = new ArrayList<>();
            ans.add(root.val);
            
            List<Integer> right = inOrder(root.right);
            
            if(right != null){
                for(int i : right){
                    ans.add(i);
                }
                
                return ans;
            }else{
                return ans;
            }
        }
    }
    
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> inorder = inOrder(root);
        
        TreeNode ans = new TreeNode(inorder.get(0));
        TreeNode temp = ans;
        
        for(int i = 1; i < inorder.size(); i++){
            temp.left = null;
            temp.right = new TreeNode(inorder.get(i));
            temp = temp.right;
        }
        
        return ans;
    }
}
