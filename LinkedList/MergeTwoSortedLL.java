/*

    Following is the Node class already written for the Linked List

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*/

public class Solution {
    
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        //Your code goes here
        if(head1 == null) {
			return head2;
		}else if(head2 == null) {
			return head1;
		}
		
		LinkedListNode<Integer> t1 = head1;
		LinkedListNode<Integer> t2 = head2;
		
		LinkedListNode<Integer> finalHead = null;
		LinkedListNode<Integer> finalTail = null;
		if(t1.data <= t2.data) {
			finalHead = t1;
			finalTail = t1;
			t1 = t1.next;
		}else {
			finalHead = t2;
			finalTail = t2;
			t2 = t2.next;
		}
		
		while(t1 != null && t2 != null) {
			if(t1.data <= t2.data) {
				finalTail.next = t1;
				finalTail = t1;
				t1 = t1.next;
			}else {
				finalTail.next = t2;
				finalTail = t2;
				t2 = t2.next;
			}
		}
		
		if(t1 != null) {
			finalTail.next = t1;
		}else {
			finalTail.next = t2;
		}
		
		return finalHead;

    }

}
