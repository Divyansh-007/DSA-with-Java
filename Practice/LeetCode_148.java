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
    
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null){
            return l2;
        }else if(l1 != null && l2 == null){
            return l1;
        }else if(l1 == null && l2 == null){
            return null;
        }
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode finalHead = null;
        ListNode finalTail = null;
        
        if(temp1.val <= temp2.val){
            finalHead = temp1;
            finalTail = temp1;
            temp1 = temp1.next;
        }else{
            finalHead = temp2;
            finalTail = temp2;
            temp2 = temp2.next;
        }
        
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                finalTail.next = temp1;
                finalTail = finalTail.next;
                temp1 = temp1.next;
            }else{
                finalTail.next = temp2;
                finalTail = finalTail.next;
                temp2 = temp2.next;
            }   
        }
        
        while(temp1 != null){
            finalTail.next = temp1;
            finalTail = finalTail.next;
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            finalTail.next = temp2;
            finalTail = finalTail.next;
            temp2 = temp2.next;
        }
        
        return finalHead;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode mid = middle(head);
        
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        
        l1 = sortList(l1);
        l2 = sortList(l2);
        
        return mergeTwoLists(l1,l2);
    }
}
