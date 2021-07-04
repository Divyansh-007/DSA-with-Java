class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
                continue;
            }
            
            map.put(nums[i],1);
        }
        
        Set<Integer> keys = map.keySet();
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> map.get(n1) - map.get(n2));
        
        for(int key : keys){
            pq.add(key);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int[] ans = new int[k];
        
        for(int i = k - 1; i >= 0; i--){
            ans[i] = pq.poll();
        }
        
        return ans;
    }
}
