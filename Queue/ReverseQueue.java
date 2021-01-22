import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void reverseQueue(Queue<Integer> input) {
		//Your code goes here
        if(input.isEmpty()){
            return;
        }
        
        // int data = input.poll();
        int data = input.remove();
        reverseQueue(input);
        // input.offer(data);
        input.add(data);
	}

}
