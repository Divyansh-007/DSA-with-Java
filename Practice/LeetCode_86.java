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
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        
        ListNode temp = head;
        ListNode firstHead = null;
        ListNode firstTail = null;
        ListNode secondHead = null;
        ListNode secondTail = null;
        
        while(temp != null){
            if(temp.val < x){
                if(firstHead == null){
                    firstHead = new ListNode(temp.val);
                    firstTail = firstHead;
                }else{
                    firstTail.next = new ListNode(temp.val);
                    firstTail = firstTail.next;
                }
            }else{
                if(secondHead == null){
                    secondHead = new ListNode(temp.val);
                    secondTail = secondHead;
                }else{
                    secondTail.next = new ListNode(temp.val);
                    secondTail = secondTail.next;
                }
            }
            
            temp = temp.next;
        }
        
        firstTail.next = secondHead;
        
        return firstHead;
        
    }
}
