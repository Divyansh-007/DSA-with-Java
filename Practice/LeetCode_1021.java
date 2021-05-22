class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        String ans = "";
        
        int flag = -1;
        if(s.charAt(0) == '('){
            flag += 1;
        }else{
            flag -= 1;
        }
        
        st.push(0);
        
        for(int i = 1; i < s.length(); i++){
            if(st.isEmpty()){
                if(s.charAt(i) == '('){
                    flag += 1;
                }else{
                    flag -= 1;
                }
                
                st.push(i);
                continue;
            }
            
            if(s.charAt(i) == '('){
                flag += 1;
            }else{
                flag -= 1;
            }
            
            if(flag == -1){
                ans += s.substring(st.peek() + 1, i);
                st.pop();
            }
        }
        
        return ans;
        
    }
}
