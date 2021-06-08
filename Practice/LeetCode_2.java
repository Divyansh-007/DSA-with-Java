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
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode smallAns = reverse(head.next);
        ListNode smallTail = smallAns;
        
        while(smallTail.next != null){
            smallTail = smallTail.next;
        }
        
        head.next = null;
        smallTail.next = head;
        return smallAns;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        
        ListNode ans = null;
        ListNode ansTail = null;
        int sum = 0;
        int carry = 0;
        
        while(temp1 != null || temp2 != null){
            if(temp1 == null){
                sum = temp2.val + carry;
            }else if(temp2 == null){
                sum = temp1.val + carry;
            }else{
                sum = temp1.val + temp2.val + carry;   
            }
            
            if(sum >= 10){
                sum = sum % 10;
                carry = 1;
            }else{
                carry = 0;
            }
            
            if(ans == null){
                ans = new ListNode(sum);
                ansTail = ans;
            }else{
                ansTail.next = new ListNode(sum);
                ansTail = ansTail.next;
            }
            
            if(temp1 != null){
                temp1 = temp1.next;    
            }
            
            if(temp2 != null){
                temp2 = temp2.next;   
            }
        }
        
        if(carry != 0){
            ansTail.next = new ListNode(carry);
        }
        
        return ans;
    }
}
