import java.util.Scanner;
import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String exp = s.nextLine();
        
        int strLen = str.length();
        int expLen = exp.length();
        
        Stack<Character> st = new Stack<>();

        for(int i = strLen - 1; i >= 0; i--){
            char ch = str.charAt(i);
            st.push(ch);
            
            if(st.peek() == exp.charAt(0)){
                int stInd = st.size() - 1;
                int j = 0;
                
                while(st.size() >= expLen && j < expLen){
                    if(exp.charAt(j) == st.get(stInd)){
                        j++;
                        stInd--;
                    }else{
                        break;
                    }
                }
                
                if(j == expLen){
                    int count = expLen;
                    
                    while(count > 0){
                        st.pop();
                        count--;
                    }
                }
            }
        }
        
        if(st.isEmpty()){
            System.out.println("FRULA");
        }else{
            while(!st.isEmpty()){
                System.out.print(st.pop());
            }
        }
	}

}
