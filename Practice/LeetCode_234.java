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
        if(head == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode revLL(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode smallOutput = revLL(head.next);
        ListNode smallTail = smallOutput;
        
        while(smallTail.next != null){
            smallTail = smallTail.next;
        }
        
        smallTail.next = head;
        head.next = null;
        return smallOutput;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode mid = middle(head);
        ListNode secondHalf = mid.next;
        mid.next = null;
        
        ListNode temp = revLL(secondHalf);
        
        while(head != null && temp != null){
            if(head.val == temp.val){
                head = head.next;
                temp = temp.next;
            }else{
                return false;
            }
        }
        
        return true;
    }
}
