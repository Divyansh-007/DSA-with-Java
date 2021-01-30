import java.util.ArrayList;

/***********
 
Following is the Linked list node structure already written 
 
class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T data) {
		 this.data=data;
	 }
}

************/


public class Solution {


	public static Node<Integer> func(Node<Integer> head,int n) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(head == null){
            return null;
        }
        
        ArrayList<Integer> org = new ArrayList<>();
        Node<Integer> temp = head;
        
        while(temp != null){
            org.add(temp.data);
            temp = temp.next;
        }
        
        ArrayList<Integer> arranged = new ArrayList();
        
        for(int i = 0; i < org.size(); i++){
            if(org.get(i) != n){
                arranged.add(org.get(i));
            }
        }
        
        for(int i = 0; i < org.size(); i++){
            if(org.get(i) == n){
                arranged.add(org.get(i));
            }
        }
        
        Node<Integer> ans = new Node(arranged.get(0));
        temp = ans;
        
        for(int i = 1; i < arranged.size(); i++){
            Node<Integer> curr = new Node(arranged.get(i));
            temp.next = curr;
            temp = curr;
        }
        
        return ans;
	}

}

