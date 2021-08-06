class Solution {
    public boolean isThree(int n) {
        if(n < 4){
            return false;
        }
        
        int root = (int)(Math.sqrt(n));
        
        for(int i = 2; i * i < n; i++){
            if(root % i == 0){
                return false;
            }
        }
        
        return true;
    }
}
