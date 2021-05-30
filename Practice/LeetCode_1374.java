class Solution {
    public String generateTheString(int n) {
        if(n % 2 != 0){
            String ans = "";
            
            while(n != 0){
                ans += 'a';
                n--;
            }
            
            return ans;
        }else{
            String ans = "";
            
            while(n != 1){
                ans += 'a';
                n--;
            }
            
            ans += 'b';
            
            return ans;
        }
    }
}
