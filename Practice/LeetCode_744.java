class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        boolean vis[] = new boolean[26];
        
        for(char ch : letters){
            vis[ch - 'a'] = true;
        }
        
        while(true){
            target++;
            if(target > 'z'){
                target = 'a';
            }
            
            if(vis[target - 'a']){
                return target;
            }
        }
    }
}
