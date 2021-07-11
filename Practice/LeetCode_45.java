class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        
        if(nums.length == 1){
            return 0;
        }
        
        int jump = 1;
        int farthest = nums[0];
        int end = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(i == nums.length-1){
                return jump;
            }
            
            farthest = Math.max(nums[i] + i, farthest);
            if(i == end){
                end = farthest;
                jump++;
            }
        }
        
        return jump;
    }
}
