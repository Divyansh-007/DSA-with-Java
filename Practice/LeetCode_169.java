class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
                continue;
            }
            
            map.put(nums[i],1);
        }
        
        Set<Integer> keys = map.keySet();
        int limit = nums.length / 2;
        int ans = 0;
        
        for(int key : keys){
            if(map.get(key) > limit){
                ans = key;
                break;
            }
        }
        
        return ans;
    }
}
