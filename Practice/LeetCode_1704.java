class Solution {
    public boolean halvesAreAlike(String s) {
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        String a = s.substring(0,(s.length() / 2));
        String b = s.substring((s.length() / 2), s.length());
        
        int count = 0;
        
        for(char ch : a.toCharArray()){
            if(vowels.contains(ch)){
                count++;
            }
        }
        
        for(char ch : b.toCharArray()){
            if(vowels.contains(ch)){
                count--;
            }
        }
        
        
        return count == 0;
    }
}
