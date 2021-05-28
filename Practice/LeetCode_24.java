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
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        
        List<Integer> nodes = new ArrayList<>();
        
        while(head != null){
            nodes.add(head.val);
            head = head.next;
        }
        
        for(int i = 0; i + 1 < nodes.size(); i = i + 2){
            int temp = nodes.get(i + 1);
            nodes.set(i + 1, nodes.get(i));
            nodes.set(i,temp);
        }
        
        ListNode ans = new ListNode(nodes.get(0));
        
        ListNode temp = ans;
        
        for(int i = 1; i < nodes.size(); i++){
            temp.next = new ListNode(nodes.get(i));
            temp = temp.next;
        }
        
        return ans;
    }
}
