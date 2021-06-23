class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
                continue;
            }
            
            map.put(nums[i],1);
        }
        
        Set<Integer> keys = map.keySet();
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            if(!keys.contains(i)){
                ans.add(i);
            }
        }
        
        return ans;
    }
}
