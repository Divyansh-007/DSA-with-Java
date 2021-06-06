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
    
    public void reverse(List<Integer> arr, int si, int ei){
        while(si < ei){
            int temp = arr.get(ei);
            arr.set(ei,arr.get(si));
            arr.set(si,temp);
            si++;
            ei--;
        }
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        
        List<Integer> nodes = new ArrayList<>();
        ListNode temp = head;
        
        while(temp != null){
            nodes.add(temp.val);
            temp = temp.next;
        }
        
        
        k = k % nodes.size();
        
        reverse(nodes,0,nodes.size() - 1);
        reverse(nodes,0,k - 1);
        reverse(nodes,k,nodes.size() - 1);
        
        ListNode ans = new ListNode(nodes.get(0));
        temp = ans;
        
        for(int i = 1; i < nodes.size(); i++){
            temp.next = new ListNode(nodes.get(i));
            temp = temp.next;
        }
        
        return ans;
    }
}
