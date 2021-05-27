class Solution {
    public String toLowerCase(String s) {
        String ans = "";
        
        for(char ch : s.toCharArray()){
            if(ch >= 65 && ch <= 90){
                ans += (char)(ch + 32);
                continue;
            }
            
            ans += ch;
        }
        
        return ans;
    }
}
