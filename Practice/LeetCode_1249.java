class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        char letters[] = s.toCharArray();
        
        for(int i = 0 ; i < letters.length; i++){
            if(letters[i] == '('){
                st.push(i);
            }
            
            if(letters[i] == ')'){
                if(!st.isEmpty()){
                    st.pop();
                }else{
                    letters[i] = '*';
                }
            }
        }
        
        while(!st.isEmpty()){
            letters[st.pop()] = '*';
        }
        
        String ans = "";
        
        for(char ch : letters){
            if(ch == '*'){
                continue;
            }else{
                ans += ch;
            }
        }
        
        return ans;
    }
}
