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
class Pair {
    int diameter;
    int height;
    
    Pair(int dia, int hgt){
        this.diameter = dia;
        this.height = hgt;
    }
}


class Solution {
    
    public Pair help(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }
        
        Pair leftAns = help(root.left);
        Pair rightAns = help(root.right);
        
        int height = 1 + Math.max(leftAns.height,rightAns.height);
        
        int op1 = leftAns.height + rightAns.height;
        int op2 = leftAns.diameter;
        int op3 = rightAns.diameter;
        
        int diameter = Math.max(op1,Math.max(op2,op3));
        
        return new Pair(diameter,height);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        return help(root).diameter;
    }
}
