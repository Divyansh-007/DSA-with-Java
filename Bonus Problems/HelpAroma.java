import java.util.Scanner;
import java.util.HashMap;

public class Main {


    public static boolean isPermutation(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        if(m != n) {
            return false;
        }
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        
        for(int i = 0; i < m && i < n; i++){
            count1[str1.charAt(i) - 'a']++;
            count2[str2.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(count1[i] != count2[i]){
                return false;
            }
        }
        
        return true;
    }

    public static boolean checkRow(String str, int[] arr) {
        String p = str.substring(arr[0] - 1, arr[1]);
        String q = str.substring(arr[2] - 1, arr[3]);

        return isPermutation(p, q);
    }


    public static void main(String[] args) {
        /* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

        // Write your code here
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int k = s.nextInt();
        int[][] testCaseArr = new int[k][4];

        for(int i = 0; i < testCaseArr.length; i++) {
            for(int j = 0; j < testCaseArr[0].length; j++) {
                testCaseArr[i][j] = s.nextInt();
            }
        }
      
        for(int i = 0; i < testCaseArr.length; i++) {
            System.out.println(checkRow(str, testCaseArr[i]));
        }

    }

}
