class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int i = 0;
        List<Integer> ans = new ArrayList<>();
        
        while(i + 1 < n){
            if(nums[i] == nums[i + 1]){
                ans.add(nums[i + 1]);
                i = i + 2;
            }else{
                i = i + 1;
            }
        }
        
        return ans;
        
    }
}
