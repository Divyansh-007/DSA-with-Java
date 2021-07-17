class Solution {
    public int help(int n,int ans[]){
        if(n == 0){
            return 0;
        } 
        
        if(n == 1){
            return 1;
        }

        if(ans[n] != 0){
            return ans[n];
        }
        
        if(n % 2 == 0){
            ans[n] = help(n / 2,ans);
            return ans[n];
        }
        else{
            ans[n] = help(n / 2,ans);
            return 1 + ans[n];
        }
    } 
    
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for(int i = 0 ; i <= n ; i++)
            ans[i] = help(i,ans);
        
        return ans;
    }
}
