class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(st.isEmpty()){
                st.push(ch);
            }else{
                if(st.peek() == ch){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
        }
        
        String revAns = "";
        
        while(!st.isEmpty()){
            revAns += st.pop();
        }
        
        String ans = "";
        
        for(int i = revAns.length() - 1; i >= 0; i--){
            ans += revAns.charAt(i);
        }
        
        return ans;
    }
}
