class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        
        for(int i = 0; i + 1 < nums.length; i++){
            if(nums[i] == nums[i + 1]){
                ans = nums[i];
                break;
            }
        }
        
        return ans;
    }
}
