class Solution {
    
    int gcd(int i, int j){
        if(j == 0){
            return i;
        }
        
        return gcd(j, i % j);
    }
    
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        
        for(int i = n; i > 1; i--){
            for(int j = 1; j < i; j++){
                if(gcd(i,j) == 1){
                    String curr = j + "/" + i;
                    ans.add(curr);
                }
            }
        }
        
        return ans;
    }
}
