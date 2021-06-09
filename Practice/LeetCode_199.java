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
    
    public List<List<Integer>> lvlOrder(TreeNode root){
        if(root == null){
            return null;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> order = new ArrayList<>();
        List<Integer> curr = null;
        
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            TreeNode front = q.poll();
            if(front == null){
                if(q.isEmpty()){
                    order.add(curr);
                    break;
                }else{
                    order.add(curr);
                    curr = null;
                    q.add(null);
                    continue;
                }
            }else{
                if(curr == null){
                    curr = new ArrayList<Integer>();
                    curr.add(front.val);
                }else{
                    curr.add(front.val);
                }
                
                if(front.left != null){
                    q.add(front.left);
                }
                
                if(front.right != null){
                    q.add(front.right);
                }
            }
        }
        
        return order;
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        List<List<Integer>> order = lvlOrder(root);
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i < order.size(); i++){
            List<Integer> curr = order.get(i);
            ans.add(curr.get(curr.size() - 1));
        }
        
        return ans;
    }
}
