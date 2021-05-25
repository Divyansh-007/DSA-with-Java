class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String codes[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<Character,String> map = new HashMap<>();
        
        for(int i = 0; i < 26; i++){
            map.put((char)('a' + i),codes[i]);
        }
        
        HashMap<String,Boolean> map1 = new HashMap<>();
        
        for(String curr : words){
            char letters[] = curr.toCharArray();
            String conc = "";
            
            for(char ch : letters){
                conc += map.get(ch);
            }
            
            if(!map1.containsKey(conc)){
                map1.put(conc,true);
            }
        }
        
        return map1.size();
    }
}
