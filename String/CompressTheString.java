
public class Solution {

    public static String getCompressedString(String input) {
        //Your code goes here.
        String ans = "";
        int charCount = 1;
        char currentChar = input.charAt(0);
        int i = 1;
        for(;i<=input.length()-1;i++) {
            if(input.charAt(i)==currentChar) {
                charCount = charCount+1;
            }else {
                if(charCount==1) {
                    ans = ans+currentChar;
                    currentChar = input.charAt(i);
                }else {
                    ans = ans+currentChar+charCount;
                    currentChar = input.charAt(i);
                    charCount = 1;
                }
            }
        }
        if(charCount==1) {
            ans = ans+currentChar;
        }else {
            ans = ans+currentChar+charCount;
        }
        return ans;
    }
}