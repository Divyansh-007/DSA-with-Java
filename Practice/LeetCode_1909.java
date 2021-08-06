class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int count  = 0;
        int index = 0;
        
        for(int i = 0; i + 1 < nums.length; i++){
            if(nums[i] > nums[i + 1] || nums[i] == nums[i + 1]){
                count++;
                index = i;
            }
        }
        
        if(count > 1){
            return false;
        }else if(count == 1){
            if(index == 0 || index == nums.length - 2){
                return true;
            }
            
            if(nums[index + 1] > nums[index - 1] || nums[index + 2] > nums[index]){
                return true;
            }else{
                return false;
            }
        }
        
        return true;
    }
}
