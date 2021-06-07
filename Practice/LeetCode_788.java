class Solution {
    
    public boolean isValid(int num){
        boolean valid = false;
        
        while(num > 0){
            if(num % 10 == 3 || num % 10 == 4 || num % 10 == 7){
                return false;
            }else if(num % 10 == 2 || num % 10 == 5 || num % 10 == 6 || num % 10 == 9){
                valid = true;
            }
            
            num = num / 10;
        }
        
        return valid;
    }
    
    public int rotatedDigits(int n) {
        int count = 0;
        
        for(int i = 1; i <= n; i++){
            if(isValid(i)){
                count++;
            }
        }
        
        return count;
    }
}
