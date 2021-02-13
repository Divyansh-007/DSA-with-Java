public class Solution {

    public static String commonPre(String str1, String str2) {
        String ans = "";
        for(int i = 0, j = 0; i <= str1.length() - 1 && j <= str2.length() - 1; i++,j++) {
            if(str1.charAt(i) != str2.charAt(j)) {
                break;
            }else {
                ans = ans + str1.charAt(i);
            }
        }

        return ans;
    }

    public static void answer(String input[]) {
        //Your code goes here
        if(input.length == 0) {
            System.out.println("");
        }

        String res = input[0];
        for(int i = 1; i <= input.length - 1; i++) {
            res = commonPre(res, input[i]);
        }

        System.out.println(res);
    }
}
