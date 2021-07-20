class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
                continue;
            }
            
            map.put(nums[i],1);
        }
        
        int[] ans = new int[2];
        int k = 0;
        Set<Integer> keys = map.keySet();
        
        for(int key : keys){
            if(map.get(key) == 1){
                ans[k] = key;
                k++;
            }
        }
        
        return ans;
    }
}
