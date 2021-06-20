class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int i = 0 ; i < n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
                continue;
            }
            
            map.put(nums[i],1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) != map.get(b) ? map.get(b) - map.get(a) : a - b);
        
        Set<Integer> keys = map.keySet();
        
        for(int key : keys){
            pq.add(key);
        }
        
        int ans[] = new int[n];
        int k = ans.length;
        
        while(k > 0){
            int curr = pq.poll();
            int freq = map.get(curr);
            
            while(freq-- > 0){
                ans[--k] = curr;
            }
        }
        
        return ans;
        
    }
}
