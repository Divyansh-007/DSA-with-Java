class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(st.isEmpty()){
                st.push(ch);
            }else{
                char top = st.peek();
                
                if((top >= 'a' && top <= 'z') && ch == Character.toUpperCase(top)){
                    st.pop();
                    continue;
                }else if((top >= 'A' && top <= 'Z') && ch == Character.toLowerCase(top)){
                    st.pop();
                    continue;
                }else{
                    st.push(ch);
                }
            }
        }
        
        String rev = "";
        
        while(!st.isEmpty()){
            rev += st.pop();
        }
        
        if(rev == "" || rev.length() == 1){
            return rev;
        }
        
        String ans = "";
        
        for(int i = rev.length() - 1; i >= 0; i--){
            ans += rev.charAt(i);
        }
        
        
        return ans;
    }
}
