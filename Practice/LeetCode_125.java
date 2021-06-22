class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        
        int si = 0;
        int ei = s.length() - 1;
        
        while(si < ei){
            if(!Character.isLetterOrDigit(s.charAt(si))){
                si++;
            }else if(!Character.isLetterOrDigit(s.charAt(ei))){
                ei--;
            }else{
                if(Character.toLowerCase(s.charAt(si)) != Character.toLowerCase(s.charAt(ei))){
                    return false;
                }
                si++;
                ei--;
            }
        }
        
        return true;
    }
}
