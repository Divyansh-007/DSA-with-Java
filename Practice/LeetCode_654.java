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
    
    public TreeNode buildTree(int[] arr, int si, int ei){
        if(si > ei){
            return null;
        }
        
        int max = arr[si];
        int maxInd = si;
        
        for(int i = si + 1; i <= ei; i++){
            if(arr[i] > max){
                max = arr[i];
                maxInd = i;
            }
        }
        
        TreeNode root = new TreeNode(max);
        root.left = buildTree(arr,si,maxInd - 1);
        root.right = buildTree(arr,maxInd + 1,ei);
        
        return root;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length - 1);
    }
}
