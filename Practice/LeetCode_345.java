class Solution {
    public String reverseVowels(String s) {
        char[] words = s.toCharArray();
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        
        int si = 0;
        int ei = words.length - 1;
        
        while(si < ei){
            if(!vowels.contains(words[si])){
                si++;
            }else{
                if(!vowels.contains(words[ei])){
                    ei--;
                }else{
                    char temp = words[ei];
                    words[ei] = words[si];
                    words[si] = temp;
                    si++;
                    ei--;
                }
            }
        }
        
        return new String(words);
    }
}
