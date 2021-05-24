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
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> nodes = new ArrayList<>();
        
        ListNode temp = head;
        
        while(temp != null){
            nodes.add(temp.val);
            temp = temp.next;
        }
        
        int dummy = nodes.get(nodes.size() - k);
        
        nodes.set(nodes.size() - k, nodes.get(k - 1));
        nodes.set(k - 1,dummy);
        
        ListNode ans = new ListNode(nodes.get(0));
        
        temp = ans;
        
        for(int i = 1; i < nodes.size(); i++){
            temp.next = new ListNode(nodes.get(i));
            temp = temp.next;
        }
        
        return ans;
    }
}
