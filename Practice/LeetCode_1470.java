class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[2*n];
        int k = 0;
        
        for(int i = 0; i < (2 * n) / 2; i++){
            ans[k] = nums[i];
            k = k + 2;
        }
        
        k = 1;
        
        for(int j = (2 * n) / 2; j < 2*n; j++){
            ans[k] = nums[j];
            k = k + 2;
        }
        
        return ans;
    
    }
}
