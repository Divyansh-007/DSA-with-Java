class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
                continue;
            }
            
            map.put(i,1);
        }
        
        int pairs = 0;
        Set<Integer> keys = map.keySet();
        
        for(int key : keys){
            int n = map.get(key);
            pairs += (n * (n - 1)) / 2;
        }
        
        return pairs;
    }
}
