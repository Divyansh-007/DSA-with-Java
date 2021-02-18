import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static int buyTicket(int input[], int k) {
        /* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        int n = input.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            q.add(i);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            pq.add(input[i]);
        }

        int time = 0;

        while(!q.isEmpty()) {
            if((input[q.peek()] == pq.peek()) && q.peek() == k) {
                time = time + 1;
                break;
            }else if(input[q.peek()] == pq.peek()) {
                time = time + 1;
                q.poll();
                pq.poll();
            }else {
                int currIndex = q.peek();
                q.poll();
                q.add(currIndex);
            }
        }

        return time;

    }
}
