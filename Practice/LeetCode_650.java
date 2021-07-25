class Solution {
    public int minSteps(int n) {
        int ans = 0;
        int d = 2;
        
        while(n > 1){
            while(n % d == 0){
                ans = ans + d;
                n = n / d;
            }
            d++;
        }
        
        return ans;
    }
}
