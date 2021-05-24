class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        
        for(int i = 0 ; i < n; i++){
            int count = 0;
            int curr = nums[i];
            for(int j = 0; j < n; j++){
                if(j == i){
                    continue;
                }
                
                if(nums[j] < curr){
                    count++;
                }
            }
            
            ans[i] = count;
        }
        
        return ans;
    }
}
