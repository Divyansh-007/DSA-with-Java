class Solution {
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i + 1 < n; i = i + 2){
            int freq = nums[i];
            int val = nums[i + 1];
            
            while(freq != 0){
                res.add(val);
                freq--;
            }
        }
        
        int ans[] = new int[res.size()];
        
        for(int i = 0 ; i < ans.length; i++){
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}
