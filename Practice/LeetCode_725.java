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
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode temp = root;
        
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        ListNode[] ans = new ListNode[k];
        int width = len / k;
        int extra = len % k;
        temp = root;
        
        for(int i = 0; i < k && temp != null; i++){
            ans[i] = temp;
            
            for(int j = 0; j < width + (extra > 0 ? 1 : 0) - 1; j++){
                temp = temp.next;
            }
            
            ListNode curr = temp.next;
            temp.next = null;
            temp = curr;
            extra--;
        }
        
        return ans;
    }
}
