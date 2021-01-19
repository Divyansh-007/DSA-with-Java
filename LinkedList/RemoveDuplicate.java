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

	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
		//Your code goes here
        if(head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode<Integer> t1 = head;
		LinkedListNode<Integer> t2 = head.next;
		
		while(t2 != null) {
			if(t2.data.equals(t1.data)) {
				t2 = t2.next;
			}else {
				t1.next = t2;
				t1 = t2;
				t2 = t2.next;
			}
		}
		t1.next = t2;
		return head;
		

	}

}