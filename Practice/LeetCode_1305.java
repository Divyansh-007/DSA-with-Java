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
                for(int elem : right){
                    left.add(elem);
                }
            }
            
            return left;
        }else{
           List<Integer> ans = new ArrayList<>();
            ans.add(root.val);
            
            List<Integer> right = inOrder(root.right);
            
            if(right != null){
                for(int elem : right){
                    ans.add(elem);
                }
            }
            
            return ans;
        }
    }
    
    public List<Integer> merge(List<Integer> l1, List<Integer> l2){
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null && l2 != null){
            return l2;
        }else if(l1 != null && l2 == null){
            return l1;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while(i < l1.size() && j < l2.size()){
            if(l1.get(i) <= l2.get(j)){
                ans.add(l1.get(i));
                i++;
            }else{
                ans.add(l2.get(j));
                j++;
            }
        }
        
        while(i < l1.size()){
            ans.add(l1.get(i));
            i++;
        }
        
        while(j < l2.size()){
            ans.add(l2.get(j));
            j++;
        }
        
        return ans;
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> inOrder1 = inOrder(root1);
        List<Integer> inOrder2 = inOrder(root2);
        
        return merge(inOrder1,inOrder2);
    }
}
