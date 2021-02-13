/*
 class ListNode<t> {
    public t data;
    public ListNode<t> next;
    public ListNode(t data)
    {
        this.data=data;
    }
 }
 */

public class Solution {
    
    public static ListNode<Integer> detectLoop(ListNode<Integer> head){
        if(head == null || head.next == null){
            return null;
        }
        
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        slow = slow.next;
        fast = fast.next.next;
        
        while(fast != null && fast.next != null){
            if(slow == fast){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(slow != fast){
            return null;
        }
        
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
    
    public static ListNode<Integer> FindNode(ListNode<Integer> head, int N) {
        /* Your class should be named solution.
         * Don't write main().
         * Don't take input, it is passed as function argument.
         * Don't print output.
         * Taking input and printing output is handled automatically.
         */
        if(head == null){
            return null;
        }
        
        ListNode<Integer> firstLoopNode = detectLoop(head);
        int count = 0;
        ListNode<Integer> temp = head;
        while(temp != firstLoopNode){
            temp = temp.next;
            count++;
        }
        
        int nth = count - (N - 1);
        
        if(nth < 0){
            return null;
        }
        
        ListNode<Integer> ans = head;
        
        for(int i = 1; i < nth; i++){
            ans = ans.next;
        }
        
        return ans;
    }
}
