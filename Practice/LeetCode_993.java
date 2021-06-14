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
    int depth;
    int parentVal;
    
    Pair(int depth, int parentVal){
        this.depth = depth;
        this.parentVal = parentVal;
    }
}

class Solution {
    
    public Pair depthAndParent(TreeNode root, int data, int level, int parent){
        if(root == null){
            return new Pair(0,-1);
        }
        
        if(root.val == data){
            return new Pair(level,parent);
        }
        
        Pair leftAns = depthAndParent(root.left,data,level + 1,root.val);
        
        if(leftAns.depth != 0){
            return leftAns;
        }
        
        return depthAndParent(root.right,data,level + 1,root.val);
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        
        Pair xAns = depthAndParent(root,x,0,root.val);
        Pair yAns = depthAndParent(root,y,0,root.val);
        
        System.out.print(xAns.parentVal + " " + yAns.parentVal);
        
        if(xAns.depth != yAns.depth){
            return false;
        }else{
            return xAns.parentVal != yAns.parentVal;
        }  
    }
}
