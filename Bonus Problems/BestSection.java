import java.util.Scanner;
import java.util.*;
public class Main {

	public static int[] optimize(int[] arr){
        List<Integer> list = new ArrayList<>();
        int i = arr.length - 2;
        
        while(i >= 0){
            if(arr[i] < arr[i + 1]){
                i--;
            }else{
                list.add(arr[i + 1]);
                i--;
            }
        }

        list.add(arr[0]);
        
        Collections.reverse(list);
        int[] newArr = new int[list.size()];
        
        for(int j = 0; j < list.size(); j++){
            newArr[j] = list.get(j);
        }
        
        return newArr;
    }
    
    public static int days(int[] arr, int count){
        int orgLen = arr.length;
        int[] modified = optimize(arr);
        
        
        if(modified.length == orgLen){
            return count - 1;
        }else{
            return days(modified,count + 1);
        }
    }
    
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
        }
        
        int no_of_days = days(arr,1);
        
        System.out.println(no_of_days);
        
	}

}
