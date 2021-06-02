class Solution {
    public int[] sumZero(int n) {
        int ans[] = new int[n];
        int entry = 1;
        
        if(n % 2 != 0){
            for(int i = 0; i + 1 < n - 1; i = i + 2){
                ans[i] = entry;
                ans[i + 1] = -1 * entry;
                entry++;
            }
        }else{
            for(int i = 0; i + 1 < n; i = i + 2){
                ans[i] = entry;
                ans[i + 1] = -entry;
                entry++;
            }
        }
        
        return ans;
    }
}
