class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> left = new HashMap<>();
        HashMap<Integer,Integer> right = new HashMap<>();
        HashMap<Integer,Integer> count = new HashMap<>();
        
        for(int i = 0 ; i < nums.length; i++){
            int elem = nums[i];
            if(left.get(elem) == null){
                left.put(elem,i);
            }
            right.put(elem,i);
            count.put(elem, count.getOrDefault(elem,0) + 1);
        }
        
        int ans = nums.length;
        int deg = Collections.max(count.values());
        
        for(int key : count.keySet()){
            if(count.get(key) == deg){
                ans = Math.min(ans, right.get(key) - left.get(key) + 1);
            }
        }
        
        return ans;
    }
}
