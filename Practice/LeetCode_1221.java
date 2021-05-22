class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int flag = 0;
        
        for(int ch : s.toCharArray()){
            if(ch == 'L'){
                flag -= 1;
            }else if(ch == 'R'){
                flag += 1;
            }
            
            if(flag == 0){
                count++;
            }
        }
        
        return count;
    }
}
