import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

	public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		//Your code goes here
        
        if(input.isEmpty() || k > input.size()){
            return input;
        }
        
        if(k <= 0){
            return input;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < k; i++){
            stack.push(input.peek());
            input.remove();
        }
        
        while(!stack.isEmpty()){
            input.offer(stack.peek());
            stack.pop();
        }
        
        for(int i = 0; i < input.size() - k; i++){
            input.offer(input.peek());
            input.remove();
        }
        
        return input;
	}

}