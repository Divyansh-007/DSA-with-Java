class Solution {
    
    public void reverse(char[] s, int si, int ei){
        while(si < ei){
            char temp = s[ei];
            s[ei] = s[si];
            s[si] = temp;
            si++;
            ei--;
        }
    }
    
    public void reverseString(char[] s) {
        reverse(s,0,s.length - 1);
    }
}
