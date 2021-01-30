import java.util.Scanner;
import java.util.*;

public class Main {

	public static int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
    
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
     	Scanner s = new Scanner(System.in);
		String[] stArr = new String[s.nextInt()];
		s.nextLine();
		for(int i = 0; i < stArr.length; i++){
			stArr[i] = s.nextLine();
		}
        System.out.println(numSpecialEquivGroups(stArr));


	}

}
