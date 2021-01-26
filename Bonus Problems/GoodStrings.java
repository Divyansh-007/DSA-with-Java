import java.util.Scanner;
import java.util.*;

public class Main {

    public static  void generateHappyStrs(int n, String str, char[] chars, List<String> list) {
        if (n == 0) {
            list.add(str);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (str.equals("") || chars[i] != str.charAt(str.length() - 1)) {
                generateHappyStrs(n - 1, str + chars[i], chars, list);
            }
        }
    }
    
    public static String getHappyString(int n, int k) {
        char[] chars = {'a', 'b', 'c'};
        List<String> list = new ArrayList<>();
        generateHappyStrs(n, "", chars, list);
        return list.size() >= k ? list.get(k - 1) : "";
    }

	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        
        System.out.println(getHappyString(n,k));

	
	}

}
