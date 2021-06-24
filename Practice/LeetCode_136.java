class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        int ans = 0;
        int i = 0;
        
        while(i + 1 < nums.length){
            if(nums[i] != nums[i + 1]){
                ans = nums[i];
                break;
            }else{
                 i = i + 2;
            }
        }
        
        if(i == nums.length - 1){
            return nums[nums.length - 1];
        }
        
        return ans;
    }
}
