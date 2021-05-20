class Solution {
    public String interpret(String command) {
        Stack<Character> st = new Stack<>();
        String ans = "";
        
        for(char ch : command.toCharArray()){
            if(ch == 'G'){
                ans = ans + ch;
            }else if (ch != ')'){
                st.push(ch);
            }else{
                if(st.size() == 1){
                    ans = ans + 'o';
                    st.pop();
                }else{
                    ans = ans + "al";
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            }
        }
        
        return ans;
    }
}
