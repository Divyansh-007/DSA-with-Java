class Solution {
    public int maxSubArray(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1] > 0 ? nums[i] + nums[i-1] : nums[i];
        }
        
        int res = Integer.MIN_VALUE;
        
        for(int i : nums){
            if(i > res){
                res= i;
            }
        }
        
        return res;   
    }
}
