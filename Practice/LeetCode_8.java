class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        boolean pos = true;
        long ans = 0;
        int i = 0;
        
        while(i < n && s.charAt(i) == ' '){
            i++;
        }
        
        if(i < n && s.charAt(i) == '+'){
            i++;
        }else if(i < n && s.charAt(i) == '-'){
            pos = false;
            i++;
        }
        
        while(i < n){
            if(Character.isDigit(s.charAt(i))){
                ans = ans * 10 + (s.charAt(i) - '0');
            }else{
                if(pos){
                    return (int)(ans);
                }else{
                    return -1 * (int)(ans);
                }
            }
            
            if(ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE){
                if(pos){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }
            
            i++;
        }
        
        if(pos){
            return (int)(ans);
        }else{
            return -1 * (int)(ans);
        }
    }
}
