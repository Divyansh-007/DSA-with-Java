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
    
    public static LinkedListNode<Integer> reverseLL(LinkedListNode<Integer> head){
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> curr = head;
		LinkedListNode<Integer> next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        //Your code goes here
        boolean ans = true;
        if(head == null) {
            return ans;
        }

        LinkedListNode<Integer> temp = head;
        int count = 0;
        while(temp != null) {
            temp = temp.next;
            count = count + 1;
        }

        int mid = 0;
        if(count % 2 == 0) {
            mid = (count / 2) ;
        }else {
            mid = (count + 1 )/ 2;
        }

        //		System.out.println(mid);

        LinkedListNode<Integer> firstHalf = head;

        int i = 1;
        while(i < mid ) {
            head = head.next;
            i = i + 1;
        }

        LinkedListNode<Integer> secondHalf = head.next;
        head.next = null;
        //		printLinkList(firstHalf);
        //		printLinkList(secondHalf);

        secondHalf = reverseLL(secondHalf);
        //		printLinkList(firstHalf);
        //		printLinkList(secondHalf);

        while(secondHalf != null) {
            if(firstHalf.data != secondHalf.data) {
                ans = false;
                break;
            }else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }
        }

        return ans;
    }

}
