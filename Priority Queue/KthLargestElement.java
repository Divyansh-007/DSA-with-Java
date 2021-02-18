import java.util.PriorityQueue;
import java.util.Arrays;


public class Solution {

    public static int kthLargest(int n, int[] input, int k) {
        // Write your code here
        if(n < k) {
            return -1;
        }

        if(n == k) {
            Arrays.sort(input);
            return input[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            pq.add(input[i]);
        }

        for(int i = k; i < n; i++) {
            if(pq.peek() < input[i]) {
                pq.poll();
                pq.add(input[i]);
            }
        }

        return pq.peek();
    }
}
