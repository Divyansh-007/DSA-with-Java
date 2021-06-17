class Solution {
    
    public boolean isPalindrome(String str, int si, int ei){
        while(si < ei){
            if(str.charAt(si) != str.charAt(ei)){
                return false;
            }
            si++;
            ei--;
        }
        
        return true;
    }
    
    public int countSubstrings(String s) {
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPalindrome(s,i,j)){
                    count++;
                }
            }
        }
        
        return count;
    }
}
