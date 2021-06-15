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

class Pair{
    int sum;
    int tilt;
    
    Pair(int sum, int tilt){
        this.sum = sum;
        this.tilt = tilt;
    }
}
class Solution {
    
    public Pair tiltHelp(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }
        
        Pair leftAns = tiltHelp(root.left);
        Pair rightAns = tiltHelp(root.right);
        int sum = root.val + leftAns.sum + rightAns.sum;
        int tilt = Math.abs(leftAns.sum - rightAns.sum) + leftAns.tilt + rightAns.tilt;
        
        return new Pair(sum,tilt);
    }
    
    public int findTilt(TreeNode root) {
        Pair ans = tiltHelp(root);
        return ans.tilt;
    }
}
