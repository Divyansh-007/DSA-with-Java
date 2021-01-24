import java.util.ArrayList;

/*Linked List Node Class

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    
    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

*/

public class Solution {
    
    public static long multiplyLL(LinkedListNode<Integer> list1, LinkedListNode<Integer> list2){
        int num1 = 0;
        int num2 = 0;
        
        while(list1 != null || list2 != null){
            if(list1 != null){
                num1 = (num1 * 10) + list1.data;
                list1 = list1.next;
            }
            
            if(list2 != null){
                num2 = (num2 * 10) + list2.data;
                list2 = list2.next;
            }
        }
        
        return num1 * num2;
    }
    
    public static void multiply(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        //Your code goes here
        if(head1 == null || head2 == null){
            System.out.println(0);
        }
        
        long product = multiplyLL(head1,head2);
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(product > 0){
        	ans.add((int)(product % 10));
            product = product / 10;
        }
        
        for(int i = ans.size() - 1; i >= 0; i--){
            System.out.print(ans.get(i) + " ");
        }

    }

}