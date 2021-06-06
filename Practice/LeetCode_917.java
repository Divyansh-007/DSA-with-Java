class Solution {
    public String reverseOnlyLetters(String s) {
        char letters[] = s.toCharArray();
        
        int si = 0;
        int ei = letters.length - 1;
        
        while(si < ei){
            if(!Character.isLetter(letters[si])){
                si++;
            }else{
                if(!Character.isLetter(letters[ei])){
                    ei--;
                }else{
                    char temp = letters[ei];
                    letters[ei] = letters[si];
                    letters[si] = temp;
                    si++;
                    ei--;
                }
            }
        }
        
        return new String(letters);
    }
}
