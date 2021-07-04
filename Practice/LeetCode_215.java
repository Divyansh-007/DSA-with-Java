class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        
        if(n < k){
            return -1;
        }
        
        if(n == k){
            Arrays.sort(nums);
            return nums[k - 1];
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }
        
        for(int i = k; i < n; i++){
            if(pq.peek() < nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        
        return pq.peek();
    }
}
