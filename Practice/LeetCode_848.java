class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] ch = s.toCharArray();
        int n = 0;
        
        for(int i = shifts.length - 1; i >= 0; i--){
            n = (n + shifts[i]) % 26;
            ch[i] += n;
            if(ch[i] > 'z'){
                ch[i] -= 26;
            }
        }
        
        return new String(ch);
    }
}
