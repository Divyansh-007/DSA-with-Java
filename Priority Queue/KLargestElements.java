import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

    public static ArrayList<Integer> kLargest(int input[], int k) {
        /* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        if(input.length <= k) {
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = 0; i < k; i++) {
                ans.add(input[i]);
            }

            return ans;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            pq.add(input[i]);
        }

        for(int i = k; i < input.length; i++) {
            if(pq.peek() < input[i]) {
                pq.poll();
                pq.add(input[i]);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        return ans;
    }
}
