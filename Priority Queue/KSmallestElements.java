import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;

public class Solution {

	public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
		// Write your code here
		if(n <= k){
            ArrayList<Integer> ans = new ArrayList<>();
            
            for(int elem : input){
                ans.add(elem);
            }
            
            return ans;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < k; i++){
            pq.add(input[i]);
        }
        
        for(int i = k; i < n; i++){
            if(pq.peek() > input[i]){
                pq.poll();
                pq.add(input[i]);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        
        return ans;
	}
}
