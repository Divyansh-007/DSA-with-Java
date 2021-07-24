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
    int maxCount = 1;
    
    public void traversal(TreeNode root, HashMap<Integer,Integer>map){
        if(root == null){
            return;
        }
        
        if(map.containsKey(root.val)){
            int freq = map.get(root.val) + 1;
            map.put(root.val,freq);
            maxCount = Math.max(maxCount,freq);
        }else{
            map.put(root.val,1);
        }
        
        traversal(root.left,map);
        traversal(root.right,map);
    }
    
    
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        traversal(root,map);
        
        List<Integer> ans = new ArrayList<>();
        
        Set<Integer> keys = map.keySet();
        
        for(int key : keys){
            if(map.get(key) == maxCount){
                ans.add(key);
            }
        }
        
        int[] res = new int[ans.size()];
        
        for(int i = 0 ; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        
        return res;
    }
}
