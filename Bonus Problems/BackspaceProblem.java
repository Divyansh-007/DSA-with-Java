import java.util.*;
public class Solution {
    public static String backspace(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '#'){
                st.push(s.charAt(i));
            }else{
                st.pop();
                continue;
            }
        }
        
        String revAns = "";
        
        while(!st.isEmpty()){
            revAns = revAns + st.pop();
        }
        
        String ans = "";
        
        for(int i = revAns.length() - 1; i >= 0; i--){
            ans= ans + revAns.charAt(i);
        }
        
        return ans;
    }
}

