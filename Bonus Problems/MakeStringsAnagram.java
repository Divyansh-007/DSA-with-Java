import java.util.HashMap;
public class Solution{
    
	public static int makeAnagram(String s1,String s2){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int ans = 0;
        
        for(int i = 0; i < s1.length(); i++){
            count1[s1.charAt(i) - 'a']++; 
        }
        
        for(int i = 0; i < s2.length(); i++){
            count2[s2.charAt(i) - 'a']++; 
        }
        
        for(int i = 0; i < 26; i++){
            ans = ans + Math.abs(count1[i] - count2[i]);
        }
        
        return ans;
        
    }

}
