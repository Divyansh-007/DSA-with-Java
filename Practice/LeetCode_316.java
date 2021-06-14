class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] vis = new boolean[26];
        char[] characters = s.toCharArray();
        
        for(char ch : characters){
            freq[ch - 'a']++;
        }
        
        Stack<Character> st = new Stack<>();
        
        for(char ch : characters){
            int ind = ch - 'a';
            freq[ind]--;
            
            if(vis[ind]){
                continue;
            }
            
            while(!st.isEmpty() && ch < st.peek() && freq[st.peek() - 'a'] != 0){
                vis[st.pop() - 'a'] = false;
            }
            
            st.push(ch);
            vis[ind] = true;
        }
        
        String revAns = "";
        
        while(!st.isEmpty()){
            revAns = revAns + st.pop();
        }
        
        String ans = "";
        
        for(int i = revAns.length() - 1; i >= 0; i--){
            ans = ans + revAns.charAt(i);
        }
        
        return ans;
    }
}
