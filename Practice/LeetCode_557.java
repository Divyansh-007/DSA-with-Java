class Solution {
    
    public void reverse(char[] ch, int si, int ei){
        while(si < ei){
            char temp = ch[ei];
            ch[ei] = ch[si];
            ch[si] = temp;
            si++;
            ei--;
        }
    }
    
    public String reverseWords(String s) {
        char[] letters = s.toCharArray();
        int wordStartIndex = 0;
        
        for(int i = 1; i < letters.length; i++){
            if(letters[i] != ' '){
                continue;
            }else{
                int wordEndIndex = i - 1;
                reverse(letters,wordStartIndex,wordEndIndex);
                wordStartIndex = i + 1;
                continue;
            }
        }
        
        reverse(letters,wordStartIndex,letters.length - 1);
        
        return new String(letters);
        
    }
}
