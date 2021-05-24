class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        char[] allowedWords = allowed.toCharArray();
        
        List<Character> allowedChars = new ArrayList<>();
        
        for(char ch : allowedWords){
            allowedChars.add(ch);
        }
        
        for(int i = 0; i < words.length; i++){
            char[] curr = words[i].toCharArray();
            int j = 0;
            
            for(; j < curr.length; j++){
                if(!allowedChars.contains(curr[j])){
                    break;
                }
            }
            
            if(j == curr.length){
                count++;
            }
        }
        
        return count;
    }
}
