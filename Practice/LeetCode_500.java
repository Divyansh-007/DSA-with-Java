class Solution {
    public String[] findWords(String[] words) {
        String[] str = {"qwertyuiop","asdfghjkl","zxcvbnm"};
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < str.length; i++){
            for(char c : str[i].toCharArray()){
                map.put(c,i);
            }
        }
        
        ArrayList<String> ans = new ArrayList<>();
        
        for(String word : words){
            int index = map.get(word.toLowerCase().charAt(0));
            for(char ch : word.toLowerCase().toCharArray()){
                if(map.get(ch) != index){
                    index = -1;
                    break;
                }
            }
            
            if(index != -1){
                ans.add(word);
            }
        }
        
        String[] res = new String[ans.size()];
        
        for(int i = 0 ; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        
        return res;
    }
}
