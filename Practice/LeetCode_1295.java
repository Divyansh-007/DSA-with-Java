class Solution {
    
    public int digits(int num){
        if(num == 0){
            return 0;
        }
        
        return 1 + digits(num / 10);
    }
    
    public int findNumbers(int[] nums) {
        int ans = 0;
        
        for(int i : nums){
            if(digits(i) % 2 == 0){
                ans++;
            }
        }
        
        return ans;
    }
}
