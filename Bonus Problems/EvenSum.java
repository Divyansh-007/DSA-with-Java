import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
	public static void main (String[] args) {
	    // Write your code here
        // Take input and print desired output
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        int odd = 0;
        
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
            sum = sum + arr[i];
            if(arr[i] % 2 != 0){
                odd++;
            }
        }
        
        if(sum % 2 == 0){
            int ways = 0;
            for(int i = 0; i < n; i++){
                int rem = sum - arr[i];
                if(rem % 2 == 0){
                    ways++;
                }
            }
            System.out.println(ways);
        }else{
            System.out.println(odd);
        }
	}
}
