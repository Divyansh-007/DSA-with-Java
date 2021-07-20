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
    List<String> ans = new ArrayList<>();
    
    public void rootToLeafPathHelp(TreeNode root, String str){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            str = str + root.val;
            ans.add(str);
        }
        
        str = str + root.val + "->";
        rootToLeafPathHelp(root.left,str);
        rootToLeafPathHelp(root.right,str);
    }
    
    public void rootToLeafPath(TreeNode root){
        rootToLeafPathHelp(root,"");
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        rootToLeafPath(root);
        return ans;
    }
}
