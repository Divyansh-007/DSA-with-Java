import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		String ans = "";
		
		while(n!=0) {
			int r = n%26;
			int q = n/26;
			
			if(r==0) {
				ans = ans+'Z';
				q = q-1;
			}else {
				ans = ans+(char)('A'+(r-1));
			}
			n = q;
		}
		String rev = "";
		for(int i=ans.length()-1;i>=0;i--) {
			rev = rev+ans.charAt(i);
		}
		
		System.out.println(rev);

	}

}
