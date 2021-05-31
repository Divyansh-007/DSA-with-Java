class Solution {
    
    public boolean match(String word, String pattern){
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();
        
        for(int i = 0; i < word.length(); i++){
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            
            if(!map1.containsKey(w)){
                map1.put(w,p);
            }
            
            if(!map2.containsKey(p)){
                map2.put(p,w);
            }
            
            if(map1.get(w) != p || map2.get(p) != w){
                return false;
            }
        }
        
        return true;
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        
        for(String word : words){
            if(match(word,pattern)){
                ans.add(word);
            }
        }
        
        return ans;
    }
}
