class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int ans[] = new int[n];
        
        for(int i = 0 ; i < n; i++){
            int actualPrice = prices[i];
            int j = i + 1;
            for(; j < n; j++){
                if(prices[j] <= actualPrice){
                    break;
                }
            }
            
            if(j != n){
                ans[i] = actualPrice - prices[j];
            }else{
                ans[i] = actualPrice;
            }
        }
        
        return ans;
    }
}
