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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aPrev = null;
        ListNode bNext = null;
        ListNode temp = list1;
        int count = 0;
        
        while(temp != null){
            if(count == a - 1){
                aPrev = temp;
            }
            
            if(count == b + 1){
                bNext = temp;
                break;
            }
            temp = temp.next;
            count++;
        }
        
        aPrev.next = list2;
        temp = list2;
        
        while(temp.next != null){
            temp = temp.next;
        }
        
        temp.next = bNext;
        
        return list1;
    }
}
