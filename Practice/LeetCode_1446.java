class Solution {
    public int maxPower(String s) {
        if(s.length() == 1){
            return 1;
        }
        
        int max = Integer.MIN_VALUE;
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }else{
                if(st.peek() == s.charAt(i)){
                    st.push(s.charAt(i));
                }else{
                    int currPow = st.size();
                    while(!st.isEmpty()){
                        st.pop();
                    }
                    st.push(s.charAt(i));
                    
                    if(currPow > max){
                        max = currPow;
                    }
                }
            }
        }
        
        if(!st.isEmpty() && st.size() > max){
            max = st.size();
        }
        
        return max;
    }
}
