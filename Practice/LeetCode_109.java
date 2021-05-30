/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    
    public TreeNode buildTree(List<Integer> arr, int si, int ei){
        if(si > ei){
            return null;
        }
        
        int mid = (si + ei) / 2;
        
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = buildTree(arr,si,mid - 1);
        root.right = buildTree(arr,mid + 1,ei);
        
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        
        while(head != null){
            nodes.add(head.val);
            head = head.next;
        }
        
        return buildTree(nodes,0,nodes.size() - 1);
    }
}
