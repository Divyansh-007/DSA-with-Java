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
    public int maxLevelSum(TreeNode root) {
        List<List<Integer>> order = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> curr = null;
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            TreeNode front = q.poll();
            if(front == null){
                if(q.isEmpty()){
                    order.add(curr);
                    break;
                }
                order.add(curr);
                curr = null;
                q.add(null);
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
        
        int max = order.get(0).get(0);
        int maxLvl = 1;
        
        for(int i = 1; i < order.size(); i++){
            int sum = 0;
            
            List<Integer> lvl = order.get(i);
            
            for(int elem : lvl){
                sum += elem;    
            }
            
            if(sum > max){
                max = sum;
                maxLvl = i + 1;
            }
        }
        
        return maxLvl;
    }
}
