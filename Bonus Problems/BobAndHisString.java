import java.util.Scanner;

public class Main {

    
    public static int playTime(String str){
        int[] index = new int[26];
        
        for(int i = 0 ; i < index.length; i++){
            index[i] = -1;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < str.length(); i++){
            if(index[str.charAt(i) - 'a'] == -1){
                index[str.charAt(i) - 'a'] = i;
            }else{
                int currDis = i - index[str.charAt(i) - 'a'] - 1;
                if(currDis > max){
                    max = currDis;
                }
            }
        }
        
        if(max == Integer.MIN_VALUE){
            return -1;
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
		Scanner s = new Scanner(System.in);
        String[] string = new String[s.nextInt()];
        s.nextLine();
        for(int i = 0; i < string.length; i++) {
            string[i] = s.nextLine();
        }

        int[] ans = new int[string.length];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = playTime(string[i]);
        }

        for(int res : ans) {
            System.out.println(res);
        }
	}

}
