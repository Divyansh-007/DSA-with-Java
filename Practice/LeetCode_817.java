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
    public int numComponents(ListNode head, int[] nums) {
        List<Integer> values = new ArrayList<>();
        
        for(int i : nums){
            values.add(i);
        }
        
        ListNode temp = head;
        int count = 0;
        
        while(temp != null){
            if(values.contains(temp.val) && (temp.next == null || !values.contains(temp.next.val))){
                count++;
            }
            
            temp = temp.next;
        }
        
        return count;
    }
}
