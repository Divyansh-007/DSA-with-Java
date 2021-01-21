/*
Structure of the Node used for implementing the Linked List

class Node<T> {
    T data;
    Node<T> next;
    Node<T> arb;

    Node(T data) {
        this.data = data;
        this.next = null;
        this.arb = null;
    }
}

*/


public class Solution {

    public static Node<Integer> clone(Node<Integer> head) {
        //Your code goes here
        Node<Integer> curr = head;
        Node<Integer> temp = null;
        
        while(curr != null){
            temp = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        
        curr = head;
        
        while(curr != null){
            if(curr.next != null){
                if(curr.arb != null){
                    curr.next.arb = curr.arb.next;
                }else{
                    curr.next.arb = curr.arb; 
                }
            }
            if(curr.next != null){
                curr = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        
        Node original = head;
        Node copy = head.next;
        temp = copy;
        
        while(original != null && copy!= null){
            
            if(original.next != null){
                original.next = original.next.next;
            }else{
                original.next = original.next;
            }
            
            if(copy.next != null){
                copy.next = copy.next.next;
            }else{
                copy.next = copy.next;
            }
            original = original.next;
            copy = copy.next;
        }
        
        return temp;
    }
}
